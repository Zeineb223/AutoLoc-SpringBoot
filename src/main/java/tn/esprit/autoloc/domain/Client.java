package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;
    @OneToMany(mappedBy="client")
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
}
