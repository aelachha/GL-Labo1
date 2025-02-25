package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.UniteEtude;
import be.labil.restapp.domain.mappers.CycleAvoidingMappingContext;
import be.labil.restapp.domain.mappers.IEtudiantMapper;
import be.labil.restapp.repositories.interfaces.IEtudiantRepository;
import be.labil.restapp.services.interfaces.IEtudiantService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private static final Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);
    private final IEtudiantRepository ietudiantRepository;

    @Override
    public Etudiant insert(Etudiant etudiant) {
        return ietudiantRepository.save(etudiant);
    }

    @Override
    public List<EtudiantDto> list() {
        Set<Etudiant> etudiantSet = new HashSet<>();
        ietudiantRepository.findAll().iterator().forEachRemaining(etudiantSet::add);
        return etudiantSet.stream().map(x->IEtudiantMapper.INSTANCE.toDto(x,new CycleAvoidingMappingContext())).toList();
//        return iEtudiantMapper.toDto(etudiantSet).stream().toList();
    }

    @Override
    public EtudiantDto update(Long id, EtudiantDto etudiantDto) {
        return ietudiantRepository.findById(id)
                .map(e -> {
                    e.setNom(etudiantDto.getNom());
                    e.setPrenom(etudiantDto.getPrenom());
                    e.setMatricule(etudiantDto.getMatricule());
                    e.setMasterType(etudiantDto.getMasterType());
                     Etudiant updateEtudiant =  ietudiantRepository.save(e);
                    log.warn ( " Mise à jour de léétudiant {} effectué avec succès" , etudiantDto.getMatricule()) ;
                    return IEtudiantMapper.INSTANCE.toDto(updateEtudiant,new CycleAvoidingMappingContext());
                })
                .orElseThrow(() -> new RuntimeException("Etudiant inconnu"));
    }

    @Override
    public Boolean delete(Long id) {
        ietudiantRepository.deleteById(id);
        return true;
    }

    @Override
    public EtudiantDto findByNom(String nom) {
        EtudiantDto etudiantDto = IEtudiantMapper.INSTANCE.toDto(ietudiantRepository.findByNom(nom),new CycleAvoidingMappingContext());
        return etudiantDto;
    }
}
