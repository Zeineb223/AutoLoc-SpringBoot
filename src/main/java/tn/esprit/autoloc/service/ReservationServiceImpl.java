package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
 private final IReservationRepository repository;
 @Override public Reservation findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation",id)); }
 @Override public List<Reservation> findAll() { return repository.findAll(); }
 @Override public Reservation create(Reservation entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getDateDebut() != null && entite.getDateFin() != null && entite.getDateFin().isBefore(entite.getDateDebut())) throw new IllegalArgumentException("Date de fin avant date de debut");
  return repository.save(entite);
 }
 @Override public Reservation update(Long id,Reservation entite) {
  Reservation existant=findById(id);
        if (entite.getDateDebut() != null && entite.getDateFin() != null && entite.getDateFin().isBefore(entite.getDateDebut())) throw new IllegalArgumentException("Date de fin avant date de debut");
  existant.setDateDebut(entite.getDateDebut());
  existant.setDateFin(entite.getDateFin());
  existant.setStatut(entite.getStatut());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Reservation",id); repository.deleteById(id); }
}
