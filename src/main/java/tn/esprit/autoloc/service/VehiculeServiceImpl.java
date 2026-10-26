package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {
 private final IVehiculeRepository repository;
 @Override public Vehicule findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicule",id)); }
 @Override public List<Vehicule> findAll() { return repository.findAll(); }
 @Override public Vehicule create(Vehicule entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getTarifJournalier() != null && entite.getTarifJournalier().signum() < 0) throw new IllegalArgumentException("Tarif journalier negatif");
  return repository.save(entite);
 }
 @Override public Vehicule update(Long id,Vehicule entite) {
  Vehicule existant=findById(id);
        if (entite.getTarifJournalier() != null && entite.getTarifJournalier().signum() < 0) throw new IllegalArgumentException("Tarif journalier negatif");
  existant.setImmatriculation(entite.getImmatriculation());
  existant.setMarque(entite.getMarque());
  existant.setModele(entite.getModele());
  existant.setCategorie(entite.getCategorie());
  existant.setTarifJournalier(entite.getTarifJournalier());
  existant.setStatut(entite.getStatut());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Vehicule",id); repository.deleteById(id); }
}
