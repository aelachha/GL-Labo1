package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public  interface IEtudiantMapper    {
    IEtudiantMapper INSTANCE = Mappers.getMapper(IEtudiantMapper.class);

    Etudiant toEntity(EtudiantDto dto,
                      @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    EtudiantDto toDto(Etudiant entity,
                      @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
