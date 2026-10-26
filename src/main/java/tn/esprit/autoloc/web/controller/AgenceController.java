package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;
@RestController @RequestMapping("/agences") @RequiredArgsConstructor @Tag(name="Agences")
public class AgenceController {
 private final IAgenceService service;
 @GetMapping @Operation(summary="Lister les agences") public List<Agence> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Agence") public Agence findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Agence") public Agence create(@RequestBody Agence entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Agence") public Agence update(@PathVariable Long id,@RequestBody Agence entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Agence") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
