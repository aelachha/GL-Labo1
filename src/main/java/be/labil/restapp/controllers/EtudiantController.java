package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.Bulletin;
import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.services.interfaces.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.*;

@Tag(name = "Etudiant", description = "L'api des étudiants")
@RestController
@RequestMapping("/api/etudiant")
@AllArgsConstructor
public class EtudiantController {

    public final IEtudiantService etudiantService;

    @PostMapping(value = "/create", produces = "application/json")
    Etudiant create(@RequestBody Etudiant etudiant) {
        return etudiantService.insert(etudiant);
    }

    @Operation(
            summary = "Récupérer la liste des étudiants",
            description = "Retourner la liste de tous les étudiants avec leurs matricules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie") })
    @GetMapping(value = "/list", produces = "application/json")
    List<EtudiantDto> list() {
        return etudiantService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    EtudiantDto update(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto) {
        return etudiantService.update(id, etudiantDto);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    Boolean delete(@PathVariable Long id) {
        return etudiantService.delete(id);
    }


    @GetMapping(value = "/getByName/{nom}", produces = "application/json")
    EtudiantDto getByName(@PathVariable String nom) {
        EtudiantDto etudiantDto = etudiantService.findByNom(nom);
        Set<NoteDto> notes = etudiantDto.getNotes();
        Map<String,List> some = new HashMap<>();

        for (NoteDto n : notes) {
            String nomUniteEtude = n.getMatiere().getUniteEtude().getNom();
            double cote = n.getCote();
            String nomMatiere = n.getMatiere().getNom();

            // Récupération de la liste si elle existe, sinon on la crée
            List<Map<String, Double>> laList = some.get(nomUniteEtude);
            if (laList == null) {
                laList = new ArrayList<>();
                some.put(nomUniteEtude, laList);
            }

            // On crée une nouvelle map pour la matiere et sa cote
            Map<String, Double> mapMatiereCote = new HashMap<>();
            mapMatiereCote.put(nomMatiere, cote);

            // On ajoute la map dans la liste
            laList.add(mapMatiereCote);
        }

        return etudiantDto;
    }


}
