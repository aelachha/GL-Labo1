package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.dtos.ShortNoteDTO;
import be.labil.restapp.domain.entities.Note;
import org.aspectj.weaver.ast.Not;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface INoteMapper {
    INoteMapper INSTANCE = Mappers.getMapper(INoteMapper.class);

    Note toEntity(NoteDto dto,
                  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    NoteDto toDto(Note entity,
                  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    NoteDto dtoToModel(ShortNoteDTO shortNoteDTO);

}
