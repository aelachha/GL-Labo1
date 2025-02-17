package be.labil.restapp.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "MATIERE")
@Getter
@Setter
@NoArgsConstructor
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int credit;
    @OneToMany(mappedBy = "matiere")
    private Set<Note> notes;
    @ManyToOne
    @JoinColumn(name = "ue_id")
    private UniteEtude ue;

}
