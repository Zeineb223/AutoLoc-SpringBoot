package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Equipement;
import java.util.List;
public interface IEquipementService {
 Equipement findById(Long id);
 List<Equipement> findAll();
 Equipement create(Equipement entite);
 Equipement update(Long id,Equipement entite);
 void deleteById(Long id);
}
