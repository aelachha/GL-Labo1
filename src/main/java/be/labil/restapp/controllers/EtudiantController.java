package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.services.interfaces.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
