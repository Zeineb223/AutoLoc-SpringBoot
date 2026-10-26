package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Contrat;
import java.util.List;
public interface IContratService {
 Contrat findById(Long id);
 List<Contrat> findAll();
 Contrat create(Contrat entite);
 Contrat update(Long id,Contrat entite);
 void deleteById(Long id);
}
