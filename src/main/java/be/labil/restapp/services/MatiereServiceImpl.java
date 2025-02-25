package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UniteEtude;
import be.labil.restapp.domain.mappers.CycleAvoidingMappingContext;
import be.labil.restapp.domain.mappers.IEtudiantMapper;
import be.labil.restapp.domain.mappers.IMatiereMapper;
import be.labil.restapp.domain.mappers.IUniteEtudeMapper;
import be.labil.restapp.repositories.interfaces.IMatiereRepository;
import be.labil.restapp.services.interfaces.IMatiereService;
import be.labil.restapp.services.interfaces.IUniteEtudeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class MatiereServiceImpl implements IMatiereService {

    private static final Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);

    private final IMatiereRepository repo;

    protected final IUniteEtudeService uniteEtudeService;



    /**
 * quand on insert une matiere en db, elle DOIT obligatoirement posséder une unité d'enseignement
 * si l'unité d'enseignement n'existe pas en db, on la crée
 * sinon on recupere l'UE  en db (via son nom) et on l'associe à la matiere
 * */
    @Override
    public Matiere insert(Matiere matiere) {
        if (matiere.getUniteEtude()==null)
                throw new RuntimeException("Veuillez renseigner l'unité d'enseignement");

        UniteEtude uniteEtude = uniteEtudeService.findByNom(matiere.getUniteEtude().getNom());

        if (uniteEtude==null)
            return repo.save(matiere);
        else
            matiere.setUniteEtude(uniteEtude);

        return repo.save(matiere);
    }

    @Override
    public List<MatiereDto> list() {
        Set<Matiere> matieres = new HashSet<>();
        repo.findAll().iterator().forEachRemaining(matieres::add);
        return matieres.stream().map(x->IMatiereMapper.INSTANCE.toDto(x,new CycleAvoidingMappingContext())).toList();
//        return mapper.toDto(matieres).stream().toList();
    }
/**
 * meme logique que pour l'insertion concernant l'unité d'enseignement
 * */
    @Override
    public MatiereDto update(Long id, MatiereDto matiereDto) {
        if (matiereDto.getUniteEtude()==null)
            throw new RuntimeException("Veuillez renseigner l'unité d'enseignement");

        return repo.findById(id)
                .map(m -> {
                    m.setNom(matiereDto.getNom());
                    m.setCredit(matiereDto.getCredit());
//                    m.setNotes(matiereDto.getNotes());
                    UniteEtude ue = uniteEtudeService.findByNom(matiereDto.getUniteEtude().getNom());
                    if (Objects.isNull(ue)){
                    m.setUniteEtude(IUniteEtudeMapper.INSTANCE.toEntity(matiereDto.getUniteEtude(),new CycleAvoidingMappingContext()));}
                    else
                        m.setUniteEtude(ue);
                    Matiere updateMatiere =  repo.save(m);
                    log.warn ( " Mise à jour de la matière {} effectué avec succès" , matiereDto.getNom()) ;
                    return IMatiereMapper.INSTANCE.toDto(updateMatiere,new CycleAvoidingMappingContext());
                })
                .orElseThrow(() -> new RuntimeException("Matière inconnue"));
    }

    @Override
    public Boolean delete(Long id) {
            repo.deleteById(id);

        return true;
    }
    @Override
    public MatiereDto findByNom(String nom) {
        return IMatiereMapper.INSTANCE.toDto(repo.findByNom(nom),new CycleAvoidingMappingContext());

    }

}
