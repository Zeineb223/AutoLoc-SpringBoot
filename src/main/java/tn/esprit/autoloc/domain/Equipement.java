package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Equipement {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String libelle;
    @ManyToMany(mappedBy="equipements")
    @JsonIgnore
    private Set<Vehicule> vehicules = new HashSet<>();
}
