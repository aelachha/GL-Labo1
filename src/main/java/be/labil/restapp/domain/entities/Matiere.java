package be.labil.restapp.domain.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "MATIERE")
@Getter @Setter @NoArgsConstructor
public class Matiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 20,nullable = false)
    private String nom;
    private int credit;
    @OneToMany(mappedBy = "matiere",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Note> notes;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ue_id")
    private UniteEtude uniteEtude;

}
