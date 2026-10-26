package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;
@RestController @RequestMapping("/employes") @RequiredArgsConstructor @Tag(name="Employes")
public class EmployeController {
 private final IEmployeService service;
 @GetMapping @Operation(summary="Lister les employes") public List<Employe> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Employe") public Employe findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Employe") public Employe create(@RequestBody Employe entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Employe") public Employe update(@PathVariable Long id,@RequestBody Employe entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Employe") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
