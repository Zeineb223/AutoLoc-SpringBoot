package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Maintenance {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    @ManyToOne(fetch=FetchType.EAGER)
    private Vehicule vehicule;
}
