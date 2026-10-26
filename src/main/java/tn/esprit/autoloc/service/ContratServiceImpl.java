package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {
 private final IContratRepository repository;
 @Override public Contrat findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contrat",id)); }
 @Override public List<Contrat> findAll() { return repository.findAll(); }
 @Override public Contrat create(Contrat entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getMontantTotal() != null && entite.getMontantTotal().signum() < 0) throw new IllegalArgumentException("Montant total negatif");
  return repository.save(entite);
 }
 @Override public Contrat update(Long id,Contrat entite) {
  Contrat existant=findById(id);
        if (entite.getMontantTotal() != null && entite.getMontantTotal().signum() < 0) throw new IllegalArgumentException("Montant total negatif");
  existant.setDateSignature(entite.getDateSignature());
  existant.setMontantTotal(entite.getMontantTotal());
  existant.setValide(entite.getValide());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Contrat",id); repository.deleteById(id); }
}
