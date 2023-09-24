package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.repository.MaterialRepo;
import dev.ose20.arknightstool.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
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
}