package be.labil.restapp.domain.dtos;

import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.domain.entities.UniteEtude;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MatiereDto {


    private Long id;
    private String nom;
    private int credit;
    @JsonManagedReference(value="matiere-note")
    private Set<NoteDto> notes;
    @JsonBackReference
    private UniteEtudeDto uniteEtude;
}
