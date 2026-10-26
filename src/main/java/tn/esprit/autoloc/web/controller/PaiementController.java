package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;
@RestController @RequestMapping("/paiements") @RequiredArgsConstructor @Tag(name="Paiements")
public class PaiementController {
 private final IPaiementService service;
 @GetMapping @Operation(summary="Lister les paiements") public List<Paiement> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Paiement") public Paiement findById(@PathVariable Long id) { return service.findById(id); }
}
