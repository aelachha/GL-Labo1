package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.mappers.IEtudiantMapper;
import be.labil.restapp.domain.mappers.IMatiereMapper;
import be.labil.restapp.repositories.interfaces.IEtudiantRepository;
import be.labil.restapp.repositories.interfaces.IMatiereRepository;
import be.labil.restapp.services.interfaces.IMatiereService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MatiereServiceImpl implements IMatiereService {

    private static final Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);

    private final IMatiereRepository repo;
    private final IMatiereMapper mapper;


    @Override
    public Matiere insert(Matiere matiere) {
        return repo.save(matiere);
    }

    @Override
    public List<MatiereDto> list() {
        Set<Matiere> matieres = new HashSet<>();
        repo.findAll().iterator().forEachRemaining(matieres::add);
        return mapper.toDto(matieres).stream().toList();
    }

    @Override
    public MatiereDto update(Long id, MatiereDto etudiantDto) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
