package be.labil.restapp.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShortNoteDTO {
    private double cote;
    private String etudiantNom;
    private String matiereNom;

}
