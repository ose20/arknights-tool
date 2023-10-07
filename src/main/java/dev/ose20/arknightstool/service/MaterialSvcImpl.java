package dev.ose20.arknightstool.service;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;
import dev.ose20.arknightstool.dto.RequiredMaterial;
import dev.ose20.arknightstool.dto.Selection;
import dev.ose20.arknightstool.repository.MaterialRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
public class MaterialSvcImpl implements MaterialSvc {
    private final MaterialRepo materialRepo;

    public MaterialSvcImpl(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }

    @Override
    public List<Material> findAll() {
        return materialRepo.selectAll();
    }

    @Override
    public Material findById(Long id) {
        return materialRepo.selectById(id);
    }

    @Override
    public MaterialDetail findDetailById(Long id) {
        return materialRepo.selectDetailById(id);
    }

    @Override
    public List<RequiredMaterial> decomposeAndCalc(List<RequiredMaterial> reqMats) {
        // 基準となる中級ランクのIDをハードコーディングしている
        final Long normId = 3L;

        // あとで復元するために <素材ID, 素材名> の map をとっておく
        Map<Long, String> nameMap = materialRepo.selectAll().stream()
                .collect(Collectors.toMap(Material::getId, Material::getName));

        // <素材ID, rankId> も同様
        Map<Long, Long> rankMap = materialRepo.selectAll().stream()
                .collect(Collectors.toMap(Material::getId, Material::getRankId));

        Map<Long, Integer> decomposed = decomposeAll(
                normId,
                rankMap,
                reqMats.stream().collect(Collectors.toMap(RequiredMaterial::getMaterialId, RequiredMaterial::getQuantity))
        );

        return decomposed.entrySet().stream()
                .map(e -> new RequiredMaterial()
                        .materialId(e.getKey())
                        .name(nameMap.get(e.getKey()))
                        .quantity(e.getValue()))
                .toList();
    }

    // <materialId, count> からなるマップを受け取り、
    // 中級より高いランクの素材を中級まで分解させた <materialId, count> マップに変換する
    private Map<Long, Integer> decomposeAll(Long normId, Map<Long, Long> rankMap, Map<Long, Integer> mp) {
        Map<Long, Integer> result = new HashMap<>();

        for (Map.Entry<Long, Integer> e : mp.entrySet()) {
            Long key = e.getKey();
            Integer value = e.getValue();
            // key じゃなくて rankId がほしい
            if (rankMap.get(key) <= normId) {
                result.put(key, result.getOrDefault(key, 0) + value);
            } else {
                addToLeft(result, decomposeOne(normId, rankMap, e), Integer::sum);
            }
        }

        return result;
    }

    private Map<Long, Integer> decomposeOne(Long normId, Map<Long, Long> rankMap, Map.Entry<Long, Integer> e) {
        List<RequiredMaterial> md = materialRepo.selectDetailById(e.getKey()).getRequiredMaterials();

        var test = md.stream().collect(Collectors.toMap(
                RequiredMaterial::getMaterialId,
                r -> r.getQuantity() * e.getValue())
        );

        return decomposeAll(normId, rankMap, test);
    }

    private <S, T> void addToLeft(Map<S, T> left, Map<S, T> right, BiFunction<? super T, ? super T, ? extends T> f) {
        right.forEach((key, value) -> left.merge(key, value, f));
    }

}
