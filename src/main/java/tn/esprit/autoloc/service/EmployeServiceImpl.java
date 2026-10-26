package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
 private final IEmployeRepository repository;
 @Override public Employe findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employe",id)); }
 @Override public List<Employe> findAll() { return repository.findAll(); }
 @Override public Employe create(Employe entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getNom() == null || entite.getNom().isBlank()) throw new IllegalArgumentException("Le nom est obligatoire");
  return repository.save(entite);
 }
 @Override public Employe update(Long id,Employe entite) {
  Employe existant=findById(id);
        if (entite.getNom() == null || entite.getNom().isBlank()) throw new IllegalArgumentException("Le nom est obligatoire");
  existant.setNom(entite.getNom());
  existant.setPrenom(entite.getPrenom());
  existant.setRole(entite.getRole());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Employe",id); repository.deleteById(id); }
}
