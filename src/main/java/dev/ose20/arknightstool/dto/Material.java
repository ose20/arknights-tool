package dev.ose20.arknightstool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    Long id;
    String name;
    Long rankId;
    Long moneyCost;
    Long staminaCost;

    public Material id(Long val) { this.id = val; return this; }
    public Material name(String val) { this.name = val; return this; }
    public Material rankId(Long val) { this.rankId = val; return this; }
    public Material moneyCost(Long val) { this.moneyCost = val; return this; }
    public Material staminaCost(Long val) { this.staminaCost = val; return this; }

    public static Material sample() {
        return new Material(1L, "初級源岩", 3L, 100L, 1L);
    }
}
