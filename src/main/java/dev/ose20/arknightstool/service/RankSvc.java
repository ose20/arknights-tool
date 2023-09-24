package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Rank;

import java.util.List;

public interface RankSvc {
    List<Rank> findAll();

    Rank findById(Long id);
}
