package dev.ose20.arknightstool.controller;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;
import dev.ose20.arknightstool.service.MaterialSvc;
import dev.ose20.arknightstool.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(MaterialRestController.class)
class MaterialRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MaterialSvc materialSvc;

    @Test
    void getMaterials() throws Exception {
        Material m1 = TestUtil.someMaterial();
        Material m2 = TestUtil.someMaterial();

        when(materialSvc.findAll()).thenReturn(Arrays.asList(m1, m2));

        mockMvc.perform(get("/v1/s/materials"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name").value(m1.getName()))
            .andExpect(jsonPath("$[1].name").value(m2.getName()))
            ;

        verify(materialSvc, times(1)).findAll();

    }

    @Test
    void getMaterial() throws Exception {
        Material m = TestUtil.someMaterial();

        when(materialSvc.findById(10L)).thenReturn(m);

        mockMvc.perform(get("/v1/s/materials/10"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.name").value(m.getName()))
            ;

        verify(materialSvc, times(1)).findById(10L);
    }

    @Test
    void getDetail() throws Exception {
        var md = new MaterialDetail()
            .material(new Material().id(40L).name("上級装置").rankId(4L).moneyCost(300L).staminaCost(4L))
            .requiredMaterials(Arrays.asList(
                new MaterialDetail.RequiredMaterial().materialId(24L).name("中級装置").quantity(1),
                new MaterialDetail.RequiredMaterial().materialId(23L).name("中級源岩").quantity(2),
                new MaterialDetail.RequiredMaterial().materialId(15L).name("砥石").quantity(1)
            ));

        when(materialSvc.findDetailById(40L)).thenReturn(md);

        mockMvc.perform(get("/v1/s/materials/detail/40"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.material.name").value(md.getMaterial().getName()))
            .andExpect(jsonPath("$.material.moneyCost").value(md.getMaterial().getMoneyCost()))
            .andExpect(jsonPath("$.requiredMaterials", hasSize(3)))
            .andExpect(jsonPath("$.requiredMaterials[0].name").value(md.getRequiredMaterials().get(0).getName()));
    }
}