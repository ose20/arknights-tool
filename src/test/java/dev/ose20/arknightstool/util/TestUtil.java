package dev.ose20.arknightstool.util;

import dev.ose20.arknightstool.dto.Material;

public class TestUtil {
    private TestUtil() {}

    public static Material someMaterial() {
        return new Material(1L, "初級源岩", 3L, 100L, 1L);
    }
}
