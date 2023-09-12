package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;
import dev.ose20.arknightstool.repository.MaterialRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialSvcImpl implements MaterialSvc {
    private final MaterialRepo materialRepo;

    public MaterialSvcImpl(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }

    @Override
    public List<Material> findAll() {
        return materialRepo.selectAll();
    }

    @Override
    public Material findById(Long id) {
        return materialRepo.selectById(id);
    }

    @Override
    public MaterialDetail findDetailById(Long id) {
        return materialRepo.selectDetailById(id);
    }
}
