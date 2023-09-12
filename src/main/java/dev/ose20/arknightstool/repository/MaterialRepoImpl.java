package dev.ose20.arknightstool.repository;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;
import dev.ose20.arknightstool.dto.MaterialDetail.RequiredMaterial;
import dev.ose20.arknightstool.exception.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class MaterialRepoImpl implements MaterialRepo {
    private final JdbcTemplate jdbcTemplate;

    public MaterialRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Material> selectAll() {
        return jdbcTemplate.query(
            "SELECT * FROM materials", new DataClassRowMapper<>(Material.class)
        );
    }

    @Override
    public Material selectById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM materials WHERE id = ?",
            new DataClassRowMapper<>(Material.class), id
        );
    }

    @Override
    public MaterialDetail selectDetailById(Long id) {

        Material material = jdbcTemplate.queryForObject(
            "SELECT * FROM materials WHERE id = ?",
            new DataClassRowMapper<>(Material.class), id
        );

        List<RequiredMaterial> recipe = jdbcTemplate.query("""
               SELECT m2.id AS materialId, m2.name AS name, r.quantity AS quantity
               FROM materials m1
               JOIN material_recipes r ON m1.id = r.res_mat_id
               JOIN materials m2 ON r.needed_mat_id = m2.id
               WHERE m1.name = ?
               """,
            new DataClassRowMapper<>(RequiredMaterial.class),
            Objects.requireNonNull(material).getName()
        );

        var result = new MaterialDetail();
        result.setMaterial(material);
        result.setRequiredMaterials(recipe);

        return result;
    }
}
