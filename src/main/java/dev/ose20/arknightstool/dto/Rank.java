package dev.ose20.arknightstool.dto;

import lombok.Data;

@Data
public class Rank {
    Long id;
    String name;
    String jpName;

    public Rank id(Long id) { this.id = id; return this; }
    public Rank name(String name) { this.name = name; return this; }
    public Rank jpName(String jpName) { this.jpName = jpName; return this; }
}
