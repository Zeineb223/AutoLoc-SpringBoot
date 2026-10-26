package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Reservation;
import java.util.List;
public interface IReservationService {
 Reservation findById(Long id);
 List<Reservation> findAll();
 Reservation create(Reservation entite);
 Reservation update(Long id,Reservation entite);
 void deleteById(Long id);
}
