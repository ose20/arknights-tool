package dev.ose20.arknightstool.dto;

import lombok.Data;

@Data
public class RequiredMaterial {
    Long materialId;
    String name;
    Integer quantity;

    public RequiredMaterial materialId(Long val) {
        this.materialId = val; return this;
    }

    public RequiredMaterial name(String val) {
        this.name = val; return this;
    }

    public RequiredMaterial quantity(Integer val) {
        this.quantity = val; return this;
    }
}
