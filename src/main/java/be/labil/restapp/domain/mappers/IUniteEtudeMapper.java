package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.dtos.UniteEtudeDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.UniteEtude;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUniteEtudeMapper extends IGenericMapper<UniteEtudeDto, UniteEtude> {
}
