package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.dtos.UniteEtudeDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UniteEtude;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface IUniteEtudeMapper  {
   IUniteEtudeMapper INSTANCE = Mappers.getMapper(IUniteEtudeMapper.class);

//    UniteEtude toEntity(UniteEtudeDto dto);
//    UniteEtudeDto toDto(UniteEtude entity);
//
//   @Mappings({@Mapping(target = "uniteEtude.matieres", ignore = true)})
//   MatiereDto toDto(Matiere matiere);
//
//   @Mappings({@Mapping(target = "uniteEtude.matieres", ignore = true)})
//   Matiere toEntity(MatiereDto matiereDto);


        UniteEtude toEntity(UniteEtudeDto dto,
                            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    UniteEtudeDto toDto(UniteEtude entity,
                        @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
