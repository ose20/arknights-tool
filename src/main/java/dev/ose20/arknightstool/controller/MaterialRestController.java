package dev.ose20.arknightstool.controller;

import dev.ose20.arknightstool.dto.Material;
import dev.ose20.arknightstool.dto.MaterialDetail;
import dev.ose20.arknightstool.dto.RequiredMaterial;
import dev.ose20.arknightstool.dto.Selection;
import dev.ose20.arknightstool.service.MaterialSvc;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/s/materials")
public class MaterialRestController {

    private final MaterialSvc materialSvc;

    public MaterialRestController(MaterialSvc materialSvc) {
        this.materialSvc = materialSvc;
    }
    @GetMapping
    public List<Material> getMaterials() {
        return materialSvc.findAll();
    }

    @GetMapping("/{id}")
    public Material getMaterial(@PathVariable Long id) { return materialSvc.findById(id); }

    @GetMapping("/detail/{id}")
    public MaterialDetail getMaterialDetail(@PathVariable Long id) {
        return materialSvc.findDetailById(id);
    }

    @PostMapping("/calculation")
    public List<RequiredMaterial> decomposeAndCalcMaterials(@RequestBody List<RequiredMaterial> requiredMaterials) {
        return materialSvc.decomposeAndCalc(requiredMaterials);
    }
}
