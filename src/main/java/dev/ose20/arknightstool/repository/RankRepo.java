package dev.ose20.arknightstool.repository;

import dev.ose20.arknightstool.dto.Rank;

import java.util.List;


public interface RankRepo {
    List<Rank> selectAll();
    Rank selectById(Long id);
}
