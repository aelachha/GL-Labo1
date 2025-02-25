package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.ShortNoteDTO;
import be.labil.restapp.domain.dtos.NoteDto;

import java.util.List;

public interface INoteService {
    NoteDto insert(ShortNoteDTO noteDto);
    List<NoteDto> list();
    NoteDto update(Long id, NoteDto noteDto);
    Boolean delete(Long id);
}
