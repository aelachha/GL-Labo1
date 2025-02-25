package be.labil.restapp.domain.dtos;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NoteDto{


    private Long id;
    private double cote;
    @JsonBackReference
    @ToString.Exclude
    private EtudiantDto etudiant;
    @JsonBackReference(value="matiere-note")
    @ToString.Exclude
    private MatiereDto matiere;

}
