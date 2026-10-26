package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;
@RestController @RequestMapping("/contrats") @RequiredArgsConstructor @Tag(name="Contrats")
public class ContratController {
 private final IContratService service;
 @GetMapping @Operation(summary="Lister les contrats") public List<Contrat> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Contrat") public Contrat findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Contrat") public Contrat create(@RequestBody Contrat entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Contrat") public Contrat update(@PathVariable Long id,@RequestBody Contrat entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Contrat") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
