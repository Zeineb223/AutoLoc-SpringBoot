package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Employe;
import java.util.List;
public interface IEmployeService {
 Employe findById(Long id);
 List<Employe> findAll();
 Employe create(Employe entite);
 Employe update(Long id,Employe entite);
 void deleteById(Long id);
}
