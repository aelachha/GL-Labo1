package be.labil.restapp.domain.dtos;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import lombok.Value;
import java.io.Serializable;

@Value
public class NoteDto implements Serializable {


    private Long id;
    private double cote;
    private Etudiant etudiant;
    private Matiere matiere;

}
