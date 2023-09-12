package dev.ose20.arknightstool.dto;

import lombok.Data;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

import java.util.List;

@Data
public class MaterialDetail {
    Material material;
    List<RequiredMaterial> requiredMaterials;

    @Data
    public static class RequiredMaterial {
        Long materialId;
        String name;
        Integer quantity;
    }

}


