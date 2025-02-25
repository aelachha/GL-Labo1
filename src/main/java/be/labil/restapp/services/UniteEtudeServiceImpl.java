package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.dtos.UniteEtudeDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UniteEtude;
import be.labil.restapp.domain.mappers.CycleAvoidingMappingContext;
import be.labil.restapp.domain.mappers.IMatiereMapper;
import be.labil.restapp.domain.mappers.IUniteEtudeMapper;
import be.labil.restapp.repositories.interfaces.IUniteEtudeRepository;
import be.labil.restapp.services.interfaces.IUniteEtudeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UniteEtudeServiceImpl implements IUniteEtudeService {

    private static final Logger log = LoggerFactory.getLogger(UniteEtudeServiceImpl.class);

    private final IUniteEtudeRepository repo;

    @Override
    public UniteEtudeDto insert(UniteEtudeDto uniteEtudeDto) throws Exception {
        Optional.ofNullable(uniteEtudeDto)
                .orElseThrow(() -> new Exception("Unité d'etude à persister est null: " + uniteEtudeDto));

//        if (Objects.nonNull(uniteEtudeDto.getMatieres()) && !uniteEtudeDto.getMatieres().isEmpty()) {
//            for (MatiereDto m : uniteEtudeDto.getMatieres()) {
//                m.setUniteEtude(uniteEtudeDto);
//            }
//        }
        UniteEtude uniteEtude = IUniteEtudeMapper.INSTANCE.toEntity(uniteEtudeDto,new CycleAvoidingMappingContext());
        return IUniteEtudeMapper.INSTANCE.toDto(repo.save(uniteEtude),new CycleAvoidingMappingContext());
    }

    @Override
    public UniteEtude findByNom(String nom) {
        return repo.findByNom(nom);
    }

    @Override
    public List<UniteEtudeDto> list() {
        Set<UniteEtude> uniteEtudes = new HashSet<>();
        repo.findAll().iterator().forEachRemaining(uniteEtudes::add);
        return uniteEtudes.stream().map(x->IUniteEtudeMapper.INSTANCE.toDto(x,new CycleAvoidingMappingContext())).toList();
    }

    @Override
    public UniteEtudeDto update(Long id, UniteEtudeDto uniteEtudeDto) {
        return repo.findById(id)
                .map(u -> {
                    u.setNom(uniteEtudeDto.getNom());
//                    if (Objects.nonNull(uniteEtudeDto.getMatieres()) && !uniteEtudeDto.getMatieres().isEmpty()) {
//                        for (MatiereDto m : uniteEtudeDto.getMatieres()) {
//                            m.setUniteEtude(uniteEtudeDto);
//                        }
//                    }
//                    u.setMatieres(uniteEtudeDto.getMatieres().stream().map(x->iMatiereMapper.toEntity(x,new CycleAvoidingMappingContext())).collect(Collectors.toSet()));

                    UniteEtude updateUniteEtude =  repo.save(u);
                    log.warn ( " Mise à jour de l'unité d'étude {} effectué avec succès" , uniteEtudeDto.getNom()) ;
                    return IUniteEtudeMapper.INSTANCE.toDto(updateUniteEtude,new CycleAvoidingMappingContext());
                })
                .orElseThrow(() -> new RuntimeException("Unité d'étude inconnue"));
    }
/**
 * ici on fait le choix de ne pas donner la possibilité de supprimer une unité d'étude si elle est liée à une ou plusieurs matières
 * */
    @Override
    public Boolean delete(Long id) {
        try {
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            log.error("Impossible de supprimer l'unité d'étude {} car elle est liée à une ou plusieurs matières",id);
            return false;
        }
        return true;    }
}
