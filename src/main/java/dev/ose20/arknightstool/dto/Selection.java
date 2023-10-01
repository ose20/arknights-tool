package dev.ose20.arknightstool.dto;

import java.util.HashMap;
import java.util.Map;

public class Selection<T> {
    private Map<Long, Integer> selections = new HashMap<>();

    public Selection selections(Map<Long, Integer> val) {
        this.selections = val; return this;
    }

    public void addSelection(Long id, Integer count) {
        this.selections.put(id, count);
    }

    public Integer getCount(Long id) {
        return this.selections.getOrDefault(id, 0);
    }
}
