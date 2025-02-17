package be.labil.restapp.domain.dtos;

import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.domain.entities.UniteEtude;
import lombok.Value;
import java.io.Serializable;
import java.util.Set;

@Value
public class MatiereDto implements Serializable {


    private Long id;
    private String nom;
    private int credit;
    private Set<Note> notes;
    private UniteEtude ue;
}
