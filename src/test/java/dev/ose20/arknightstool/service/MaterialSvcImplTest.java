package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;
import dev.ose20.arknightstool.dto.RequiredMaterial;
import dev.ose20.arknightstool.repository.MaterialRepo;
import dev.ose20.arknightstool.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MaterialSvcImplTest {

    MaterialSvc materialSvc;

    @Mock
    MaterialRepo materialRepo;

    @BeforeEach
    void setUp() {
        this.materialSvc = new MaterialSvcImpl(materialRepo);
    }

    @Test
    void findAll() {
        List<Material> expect = new ArrayList<>();
        {
            Material data = TestUtil.someMaterial();
            expect.add(data);
        }
        doReturn(expect).when(materialRepo).selectAll();
        List<Material> actual = materialSvc.findAll();

        assertThat(actual).isEqualTo(expect);
        verify(materialRepo, times(1)).selectAll();
    }

    @Test
    void findById() {
        Material expect = TestUtil.someMaterial();
        doReturn(expect).when(materialRepo).selectById(10L);
        Material actual = materialSvc.findById(10L);

        assertThat(actual).isEqualTo(expect);
        verify(materialRepo, times(1)).selectById(10L);
    }

    @Test
    void findDetailById() {
        var expect = new MaterialDetail()
            .material(new Material().id(40L).name("上級装置").rankId(4L).moneyCost(300L).staminaCost(4L))
            .requiredMaterials(Arrays.asList(
                new RequiredMaterial().materialId(24L).name("中級装置").quantity(1),
                new RequiredMaterial().materialId(23L).name("中級源岩").quantity(2),
                new RequiredMaterial().materialId(15L).name("砥石").quantity(1)
            ));

        when(materialRepo.selectDetailById(40L)).thenReturn(expect);

        MaterialDetail actual = materialSvc.findDetailById(40L);
        assertThat(actual).isEqualTo(expect);
        verify(materialRepo, times(1)).selectDetailById(40L);

    }
}