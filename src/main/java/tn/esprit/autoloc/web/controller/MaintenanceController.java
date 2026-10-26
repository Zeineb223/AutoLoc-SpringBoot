package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;
@RestController @RequestMapping("/maintenances") @RequiredArgsConstructor @Tag(name="Maintenances")
public class MaintenanceController {
 private final IMaintenanceService service;
 @GetMapping @Operation(summary="Lister les maintenances") public List<Maintenance> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Maintenance") public Maintenance findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Maintenance") public Maintenance create(@RequestBody Maintenance entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Maintenance") public Maintenance update(@PathVariable Long id,@RequestBody Maintenance entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Maintenance") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
