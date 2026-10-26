package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;
@RestController @RequestMapping("/clients") @RequiredArgsConstructor @Tag(name="Clients")
public class ClientController {
 private final IClientService service;
 @GetMapping @Operation(summary="Lister les clients") public List<Client> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Client") public Client findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Client") public Client create(@RequestBody Client entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Client") public Client update(@PathVariable Long id,@RequestBody Client entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Client") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
