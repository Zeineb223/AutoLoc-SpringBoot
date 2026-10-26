package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
 private final IEquipementRepository repository;
 @Override public Equipement findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipement",id)); }
 @Override public List<Equipement> findAll() { return repository.findAll(); }
 @Override public Equipement create(Equipement entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getLibelle() == null || entite.getLibelle().isBlank()) throw new IllegalArgumentException("Libelle obligatoire");
  return repository.save(entite);
 }
 @Override public Equipement update(Long id,Equipement entite) {
  Equipement existant=findById(id);
        if (entite.getLibelle() == null || entite.getLibelle().isBlank()) throw new IllegalArgumentException("Libelle obligatoire");
  existant.setLibelle(entite.getLibelle());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Equipement",id); repository.deleteById(id); }
}
