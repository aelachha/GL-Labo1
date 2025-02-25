package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.dtos.UniteEtudeDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UniteEtude;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Mapper
public interface   IMatiereMapper {
     IMatiereMapper INSTANCE = Mappers.getMapper(IMatiereMapper.class);


//     Matiere toEntity(MatiereDto dto);
//     MatiereDto toDto(Matiere entity);
//
//     @Mappings({
//             @Mapping(target = "matieres", ignore = true)
//     })
//     UniteEtudeDto toEntity(UniteEtude uniteEtude);
//
//     @Mappings({
//             @Mapping(target = "matieres", ignore = true)
//     })
//     UniteEtude toDto(UniteEtudeDto parentDTO);


     Matiere toEntity(MatiereDto dto,
                         @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
     MatiereDto toDto(Matiere entity,
                         @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
