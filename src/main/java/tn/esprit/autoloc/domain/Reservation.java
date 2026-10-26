package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING) private StatutReservation statut;
    @ManyToOne(fetch=FetchType.EAGER)
    private Client client;
    @ManyToOne(fetch=FetchType.EAGER)
    private Vehicule vehicule;
    @OneToOne(mappedBy="reservation")
    @JsonIgnore
    private Contrat contrat;
}
