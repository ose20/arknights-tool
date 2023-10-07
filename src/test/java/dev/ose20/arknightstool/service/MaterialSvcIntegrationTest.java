package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.RequiredMaterial;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class MaterialSvcIntegrationTest {
    @Autowired
    MaterialSvc materialSvc;

    @Test
    public void decomposeAndCalc() {
        List<RequiredMaterial> data = Arrays.asList(
                new RequiredMaterial().materialId(46L).name("ナノフレーク").quantity(2),
                new RequiredMaterial().materialId(39L).name("上級源岩").quantity(10)
        );

        // 可変リストにするために ArrayList<>() でラップしている
        List<RequiredMaterial> actual = new ArrayList<>(materialSvc.decomposeAndCalc(data));
        actual.sort(Comparator.comparingLong(RequiredMaterial::getMaterialId));
        System.out.println(actual);

        // Todo: assertionを書こうね
        assertThat(actual.get(0).getMaterialId()).isEqualTo(13L);
        assertThat(actual.get(0).getName()).isEqualTo("合成コール");
        assertThat(actual.get(0).getQuantity()).isEqualTo(4);
        assertThat(actual.get(2).getMaterialId()).isEqualTo(16L);
        assertThat(actual.get(2).getName()).isEqualTo("RMA70-12");
        assertThat(actual.get(2).getQuantity()).isEqualTo(4);
    }

}
