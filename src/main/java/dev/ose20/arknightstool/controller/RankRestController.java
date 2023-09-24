package dev.ose20.arknightstool.controller;

import dev.ose20.arknightstool.dto.Rank;
import dev.ose20.arknightstool.service.RankSvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/s/ranks")
public class RankRestController {
    private final RankSvc rankSvc;

    public RankRestController(RankSvc rankSvc) { this.rankSvc = rankSvc; }

    @GetMapping
    public List<Rank> getRanks() { return rankSvc.findAll(); }

    @GetMapping("/{id}")
    public Rank getRank(@PathVariable Long id) { return rankSvc.findById(id); }
}
