package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
 private final IAgenceRepository repository;
 @Override public Agence findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agence",id)); }
 @Override public List<Agence> findAll() { return repository.findAll(); }
 @Override public Agence create(Agence entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getNom() == null || entite.getNom().isBlank()) throw new IllegalArgumentException("Le nom est obligatoire");
  return repository.save(entite);
 }
 @Override public Agence update(Long id,Agence entite) {
  Agence existant=findById(id);
        if (entite.getNom() == null || entite.getNom().isBlank()) throw new IllegalArgumentException("Le nom est obligatoire");
  existant.setNom(entite.getNom());
  existant.setVille(entite.getVille());
  existant.setAdresse(entite.getAdresse());
  existant.setTelephone(entite.getTelephone());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Agence",id); repository.deleteById(id); }
}
