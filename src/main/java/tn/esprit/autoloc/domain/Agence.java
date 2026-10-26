package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Agence {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;
    @OneToMany(mappedBy="agence")
    @JsonIgnore
    private List<Employe> employes = new ArrayList<>();
    @OneToMany(mappedBy="agence")
    @JsonIgnore
    private List<Vehicule> vehicules = new ArrayList<>();
}
