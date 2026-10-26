package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;
public interface IVehiculeService {
 Vehicule findById(Long id);
 List<Vehicule> findAll();
 Vehicule create(Vehicule entite);
 Vehicule update(Long id,Vehicule entite);
 void deleteById(Long id);
}
