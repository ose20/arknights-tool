package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Rank;
import dev.ose20.arknightstool.repository.RankRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankSvcImpl implements RankSvc {
    private final RankRepo rankRepo;

    public RankSvcImpl(RankRepo rankRepo) {
        this.rankRepo = rankRepo;
    }

    @Override public List<Rank> findAll() {
        return rankRepo.selectAll();
    }

    @Override public Rank findById(Long id) {
        return rankRepo.selectById(id);
    }

}
