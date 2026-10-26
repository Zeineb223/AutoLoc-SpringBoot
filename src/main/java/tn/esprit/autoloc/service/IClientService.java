package tn.esprit.autoloc.service;
import tn.esprit.autoloc.domain.Client;
import java.util.List;
public interface IClientService {
 Client findById(Long id);
 List<Client> findAll();
 Client create(Client entite);
 Client update(Long id,Client entite);
 void deleteById(Long id);
}
