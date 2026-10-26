package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Agence;
import java.util.List;
public interface IAgenceService {
 Agence findById(Long id);
 List<Agence> findAll();
 Agence create(Agence entite);
 Agence update(Long id,Agence entite);
 void deleteById(Long id);
}
