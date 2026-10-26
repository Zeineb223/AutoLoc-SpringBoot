package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contrat {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private Boolean valide;
    @OneToOne(fetch=FetchType.EAGER)
    private Reservation reservation;
    @OneToMany(mappedBy="contrat",cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference("contrat-paiements")
    private List<Paiement> paiements = new ArrayList<>();
    public void setPaiements(List<Paiement> paiements) {
        this.paiements.clear();
        if (paiements != null) for (Paiement p : paiements) { p.setContrat(this); this.paiements.add(p); }
    }
}
