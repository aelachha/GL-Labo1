package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.dtos.ShortNoteDTO;
import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.domain.mappers.CycleAvoidingMappingContext;
import be.labil.restapp.domain.mappers.INoteMapper;
import be.labil.restapp.repositories.interfaces.INoteRepository;
import be.labil.restapp.services.interfaces.IEtudiantService;
import be.labil.restapp.services.interfaces.INoteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
public class NoteServiceImpl implements INoteService {
    private static final Logger log = LoggerFactory.getLogger(NoteServiceImpl.class);

    private final INoteRepository repo;
    private final EtudiantServiceImpl etudiantService;
    private final MatiereServiceImpl matiereService;


    @Override
    public NoteDto insert(ShortNoteDTO shortNoteDTO) {

        NoteDto noteDto = INoteMapper.INSTANCE.dtoToModel(shortNoteDTO);
        EtudiantDto etudiantDto = etudiantService.findByNom(shortNoteDTO.getEtudiantNom());
        MatiereDto matiereDto = matiereService.findByNom(shortNoteDTO.getMatiereNom());
        noteDto.setMatiere(matiereDto);
        noteDto.setEtudiant(etudiantDto);

        Note note = INoteMapper.INSTANCE.toEntity(noteDto,new CycleAvoidingMappingContext());

        return INoteMapper.INSTANCE.toDto(repo.save(note),new CycleAvoidingMappingContext());
    }

    @Override
    public List<NoteDto> list() {
        Set<Note> noteSet = new HashSet<>();
        repo.findAll().iterator().forEachRemaining(noteSet::add);
        return noteSet.stream().map(x->INoteMapper.INSTANCE.toDto(x,new CycleAvoidingMappingContext())).toList();
//        return mapper.toDto(noteSet).stream().toList();
    }

    @Override
    public NoteDto update(Long id, NoteDto noteDto) {
        return repo.findById(id)
                .map(n -> {
                    n.setCote(noteDto.getCote());
                    Note updateNote =  repo.save(n);
                    log.warn ( " Mise à jour de la note {} effectué avec succès" , noteDto.getCote()) ;
                    return INoteMapper.INSTANCE.toDto(updateNote,new CycleAvoidingMappingContext());
                })
                .orElseThrow(() -> new RuntimeException("Note inconnue"));
    }

    @Override
    public Boolean delete(Long id) {
        repo.deleteById(id);
        return true;
    }
}
