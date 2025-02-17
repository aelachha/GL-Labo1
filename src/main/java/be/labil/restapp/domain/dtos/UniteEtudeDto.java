package be.labil.restapp.domain.dtos;

import be.labil.restapp.domain.entities.Matiere;
import lombok.Value;
import java.io.Serializable;
import java.util.Set;

@Value
public class UniteEtudeDto implements Serializable {

    private Long id;
    private String nom;
    private Set<Matiere> matieres;
}
