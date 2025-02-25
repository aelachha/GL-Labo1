package be.labil.restapp.domain.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EtudiantDto {

    private Long id;
    @NotNull(message = "Le matricule ne peut pas être vide")
    private String matricule;
    private String nom;
    private String prenom;
    private String masterType;
    @JsonManagedReference
    private Set<NoteDto> notes;

}
