package dev.ose20.arknightstool.controller;

import dev.ose20.arknightstool.dto.Rank;
import dev.ose20.arknightstool.service.RankSvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(RankRestController.class)
public class RankRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RankSvc rankSvc;

    @Test
    void getMaterials() throws Exception {
        var r1 = new Rank().id(1L).name("common").jpName("基礎");
        var r2 = new Rank().id(2L).name("basic").jpName("初級");

        when(rankSvc.findAll()).thenReturn(Arrays.asList(r1, r2));

        mockMvc.perform(get("/v1/s/ranks"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name").value(r1.getName()))
            .andExpect(jsonPath("$[1].name").value(r2.getName()))
        ;

        verify(rankSvc, times(1)).findAll();
    }

    @Test
    void getMaterial() throws Exception {
        var r = new Rank().id(1L).name("epic").jpName("高級");

        when(rankSvc.findById(1L)).thenReturn(r);

        mockMvc.perform(get("/v1/s/ranks/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.name").value(r.getName()))
        ;

        verify(rankSvc, times(1)).findById(1L);
    }
}
