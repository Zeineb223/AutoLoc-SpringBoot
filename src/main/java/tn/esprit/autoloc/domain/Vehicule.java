package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vehicule {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String immatriculation;
    private String marque;
    private String modele;
    @Enumerated(EnumType.STRING) private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING) private StatutVehicule statut;
    @ManyToOne(fetch=FetchType.EAGER)
    private Agence agence;
    @OneToMany(mappedBy="vehicule")
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();
    @OneToMany(mappedBy="vehicule")
    @JsonIgnore
    private List<Maintenance> maintenances = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="vehicule_equipement",joinColumns=@JoinColumn(name="vehicule_id"),inverseJoinColumns=@JoinColumn(name="equipement_id"))
    private Set<Equipement> equipements = new HashSet<>();
}
