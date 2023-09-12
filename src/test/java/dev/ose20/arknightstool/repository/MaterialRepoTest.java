package dev.ose20.arknightstool.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
public class MaterialRepoTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    MaterialRepo materialRepo;

    @BeforeEach
    void setup() {
        materialRepo = new MaterialRepoImpl(jdbcTemplate);
    }

    @Test
    void selectAll() {
        var materials = materialRepo.selectAll();
        assertThat(materials.size()).isEqualTo(49);
        var material = materials.get(0);
        assertThat(material.getName()).isEqualTo("源岩鉱");
    }

    @Test
    void selectById() {
        var material = materialRepo.selectById(2L);
        // (2, '破損装置', 1, null, null),
        assertThat(material.getId()).isEqualTo(2L);
        assertThat(material.getName()).isEqualTo("破損装置");
        assertThat(material.getMoneyCost()).isNull();
        assertThat(material.getStaminaCost()).isNull();
    }


}
