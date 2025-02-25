package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UniteEtude;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMatiereService {
    Matiere insert(Matiere matiere);
    List<MatiereDto> list();
    MatiereDto update(Long id, MatiereDto etudiantDto);
    Boolean delete(Long id);
    MatiereDto findByNom(String nom);

}
