package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.UniteEtude;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEtudiantService {
    Etudiant insert(Etudiant etudiant);
    List<EtudiantDto> list();
    EtudiantDto update(Long id, EtudiantDto etudiantDto);
    Boolean delete(Long id);
    EtudiantDto findByNom(String nom);

}
