package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Rank;
import dev.ose20.arknightstool.repository.RankRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RankSvcTest {
    RankSvc rankSvc;

    @Mock
    RankRepo rankRepo;

    @BeforeEach
    void setUp() {
        this.rankSvc = new RankSvcImpl(rankRepo);
    }

    @Test
    void findAll() {
        List<Rank> expect = Arrays.asList(
            new Rank().id(1L).name("intermediate").jpName("中級"),
            new Rank().id(2L).name("advanced").jpName("高級")
        );

        when(rankSvc.findAll()).thenReturn(expect);

        List<Rank> actual = rankSvc.findAll();
        assertThat(actual).isEqualTo(expect);
        verify(rankRepo, times(1)).selectAll();
    }

    @Test
    void findById() {
        var expect = new Rank().id(2L).name("basic").jpName("初級");

        when(rankRepo.selectById(2L)).thenReturn(expect);
        Rank actual = rankSvc.findById(2L);

        assertThat(actual).isEqualTo(expect);
        verify(rankRepo, times(1)).selectById(2L);
    }
}
