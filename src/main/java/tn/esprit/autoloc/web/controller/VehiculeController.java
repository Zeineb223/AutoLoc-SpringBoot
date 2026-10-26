package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;
@RestController @RequestMapping("/vehicules") @RequiredArgsConstructor @Tag(name="Vehicules")
public class VehiculeController {
 private final IVehiculeService service;
 @GetMapping @Operation(summary="Lister les vehicules") public List<Vehicule> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Vehicule") public Vehicule findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Vehicule") public Vehicule create(@RequestBody Vehicule entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Vehicule") public Vehicule update(@PathVariable Long id,@RequestBody Vehicule entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Vehicule") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
