package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;

import java.util.List;

public interface MaterialSvc {
    List<Material> findAll();
    Material findById(Long id);
    MaterialDetail findDetailById(Long id);
}
