package dev.ose20.arknightstool.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
public class RankRepoTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    RankRepo rankRepo;

    @BeforeEach
    void setup() {
        rankRepo = new RankRepoImpl(jdbcTemplate);
    }

    @Test
    void selectAll() {
        var ranks = rankRepo.selectAll();
        assertThat(ranks.size()).isEqualTo(5);
        var rank = ranks.get(0);
        assertThat(rank.getName()).isEqualTo("common");
    }

    @Test
    void selectById() {
        var rank = rankRepo.selectById(3L);
        assertThat(rank.getId()).isEqualTo(3L);
        assertThat(rank.getName()).isEqualTo("intermediate");
    }
}
