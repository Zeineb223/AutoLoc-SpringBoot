package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;
@RestController @RequestMapping("/equipements") @RequiredArgsConstructor @Tag(name="Equipements")
public class EquipementController {
 private final IEquipementService service;
 @GetMapping @Operation(summary="Lister les equipements") public List<Equipement> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Equipement") public Equipement findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Equipement") public Equipement create(@RequestBody Equipement entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Equipement") public Equipement update(@PathVariable Long id,@RequestBody Equipement entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Equipement") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
