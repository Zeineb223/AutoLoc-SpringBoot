package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Employe {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING) private RoleEmploye role;
    @ManyToOne(fetch=FetchType.EAGER)
    private Agence agence;
}
