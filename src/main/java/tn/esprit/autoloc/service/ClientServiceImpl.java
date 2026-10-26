package tn.esprit.autoloc.service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
@Service @RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
 private final IClientRepository repository;
 @Override public Client findById(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client",id)); }
 @Override public List<Client> findAll() { return repository.findAll(); }
 @Override public Client create(Client entite) {
  if (entite.getId()!=null) throw new IllegalArgumentException("Identifiant interdit lors de la creation");
        if (entite.getNom() == null || entite.getNom().isBlank()) throw new IllegalArgumentException("Le nom est obligatoire");
        if (entite.getEmail() == null || entite.getEmail().isBlank()) throw new IllegalArgumentException("Email obligatoire");
  return repository.save(entite);
 }
 @Override public Client update(Long id,Client entite) {
  Client existant=findById(id);
        if (entite.getNom() == null || entite.getNom().isBlank()) throw new IllegalArgumentException("Le nom est obligatoire");
        if (entite.getEmail() == null || entite.getEmail().isBlank()) throw new IllegalArgumentException("Email obligatoire");
  existant.setNom(entite.getNom());
  existant.setPrenom(entite.getPrenom());
  existant.setEmail(entite.getEmail());
  existant.setTelephone(entite.getTelephone());
  existant.setNumPermis(entite.getNumPermis());
  existant.setDateInscription(entite.getDateInscription());
  return repository.save(existant);
 }
 @Override public void deleteById(Long id) { if (!repository.existsById(id)) throw new ResourceNotFoundException("Client",id); repository.deleteById(id); }
}
