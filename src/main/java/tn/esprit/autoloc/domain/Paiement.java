package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Paiement {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private BigDecimal montant;
    private LocalDate datePaiement;
    @Enumerated(EnumType.STRING) private ModePaiement modePaiement;
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference("contrat-paiements")
    private Contrat contrat;
}
