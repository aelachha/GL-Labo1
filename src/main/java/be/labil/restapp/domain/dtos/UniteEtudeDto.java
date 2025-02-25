package be.labil.restapp.domain.dtos;

import be.labil.restapp.domain.entities.Matiere;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UniteEtudeDto {

    private Long id;
    private String nom;
    @JsonManagedReference
    private Set<MatiereDto> matieres = new HashSet<>();
}
