package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.dtos.UniteEtudeDto;
import be.labil.restapp.domain.entities.UniteEtude;

import java.util.List;

public interface IUniteEtudeService {
    UniteEtudeDto insert(UniteEtudeDto uniteEtude) throws Exception;
    UniteEtude findByNom(String nom);
    List<UniteEtudeDto> list();
    UniteEtudeDto update(Long id, UniteEtudeDto uniteEtudeDto);
    Boolean delete(Long id);

}
