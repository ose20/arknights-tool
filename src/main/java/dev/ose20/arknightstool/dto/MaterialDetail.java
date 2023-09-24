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

        public RequiredMaterial materialId(Long val) { this.materialId = val; return this; }
        public RequiredMaterial name(String val) { this.name = val; return this; }
        public RequiredMaterial quantity(Integer val) { this.quantity = val; return this; }
    }

    public MaterialDetail material(Material val) { this.material = val; return this; }
    public MaterialDetail requiredMaterials(List<RequiredMaterial> val) { this.requiredMaterials = val; return this; }

}


