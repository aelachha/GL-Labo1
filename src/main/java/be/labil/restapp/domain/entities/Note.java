package be.labil.restapp.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NOTE")
@Getter @Setter @NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cote;


    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;
}
