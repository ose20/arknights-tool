package dev.ose20.arknightstool.repository;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;

import java.util.List;

public interface MaterialRepo {
    List<Material> selectAll();
    Material selectById(Long id);
    MaterialDetail selectDetailById(Long id);
}
