package dev.ose20.arknightstool.repository;

import dev.ose20.arknightstool.dto.Rank;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankRepoImpl implements RankRepo {
    private final JdbcTemplate jdbcTemplate;

    public RankRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override public List<Rank> selectAll() {
        return jdbcTemplate.query(
            "SELECT * FROM ranks", new DataClassRowMapper<>(Rank.class)
        );
    }

    @Override public Rank selectById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM ranks WHERE id = ?",
            new DataClassRowMapper<>(Rank.class), id
        );
    }

}
