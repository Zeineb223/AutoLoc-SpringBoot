package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {
 private final IMaintenanceRepository repository;
 @Override public Maintenance findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Maintenance",id)); }
 @Override public List<Maintenance> findAll() { return repository.findAll(); }
 @Override public Maintenance create(Maintenance entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getDateDebut() != null && entite.getDateFin() != null && entite.getDateFin().isBefore(entite.getDateDebut())) throw new IllegalArgumentException("Dates de maintenance invalides");
  return repository.save(entite);
 }
 @Override public Maintenance update(Long id,Maintenance entite) {
  Maintenance existant=findById(id);
        if (entite.getDateDebut() != null && entite.getDateFin() != null && entite.getDateFin().isBefore(entite.getDateDebut())) throw new IllegalArgumentException("Dates de maintenance invalides");
  existant.setDateDebut(entite.getDateDebut());
  existant.setDateFin(entite.getDateFin());
  existant.setDescription(entite.getDescription());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Maintenance",id); repository.deleteById(id); }
}
