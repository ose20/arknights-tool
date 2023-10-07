package dev.ose20.arknightstool.dto;

import lombok.Data;

import java.util.List;

@Data
public class MaterialDetail {
    Material material;
    List<RequiredMaterial> requiredMaterials;

    public MaterialDetail material(Material val) { this.material = val; return this; }
    public MaterialDetail requiredMaterials(List<RequiredMaterial> val) { this.requiredMaterials = val; return this; }

}


