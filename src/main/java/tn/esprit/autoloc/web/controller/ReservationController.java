package tn.esprit.autoloc.web.controller;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;
@RestController @RequestMapping("/reservations") @RequiredArgsConstructor @Tag(name="Reservations")
public class ReservationController {
 private final IReservationService service;
 @GetMapping @Operation(summary="Lister les reservations") public List<Reservation> findAll() { return service.findAll(); }
 @GetMapping("/{id}") @Operation(summary="Consulter Reservation") public Reservation findById(@PathVariable Long id) { return service.findById(id); }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Creer Reservation") public Reservation create(@RequestBody Reservation entite) { return service.create(entite); }
 @PutMapping("/{id}") @Operation(summary="Modifier Reservation") public Reservation update(@PathVariable Long id,@RequestBody Reservation entite) { return service.update(id,entite); }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Operation(summary="Supprimer Reservation") public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
