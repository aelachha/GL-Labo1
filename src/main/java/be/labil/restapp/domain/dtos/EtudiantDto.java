package be.labil.restapp.domain.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

@Value
public class EtudiantDto implements Serializable {

    private Long id;
    @NotNull(message = "Le matricule ne peut pas être vide")
    private String matricule;
    private String nom;
    private String prenom;
    private String masterType;

}
