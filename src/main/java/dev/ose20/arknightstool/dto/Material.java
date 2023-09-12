package dev.ose20.arknightstool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Material {
    Long id;
    String name;
    Long rankId;
    Long moneyCost;
    Long staminaCost;

    public static Material sample() {
        return new Material(1L, "初級源岩", 3L, 100L, 1L);
    }
}
