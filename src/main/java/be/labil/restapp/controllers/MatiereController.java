package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.services.interfaces.IEtudiantService;
import be.labil.restapp.services.interfaces.IMatiereService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Tag(name = "Matiere", description = "L'api des matières")
@RestController
@RequestMapping("/api/matiere")
@AllArgsConstructor
public class MatiereController {

    public final IMatiereService iMatiereService;

    @PostMapping(value = "/create", produces = "application/json")
    Matiere create(@RequestBody Matiere matiere) {
        return iMatiereService.insert(matiere);
    }

    @Operation(
            summary = "Récupérer la liste des matières",
            description = "Retourner la liste de tous les matieres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie") })
    @GetMapping(value = "/list", produces = "application/json")
    List<MatiereDto> list() {
        return iMatiereService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    MatiereDto update(@PathVariable Long id, @RequestBody MatiereDto matiereDto) {
        return iMatiereService.update(id, matiereDto);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    Boolean delete(@PathVariable Long id) {
        return iMatiereService.delete(id);
    }

}
