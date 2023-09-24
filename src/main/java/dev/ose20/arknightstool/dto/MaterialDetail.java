package dev.ose20.arknightstool.dto;

import lombok.Data;

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


