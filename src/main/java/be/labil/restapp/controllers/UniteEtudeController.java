package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.UniteEtudeDto;
import be.labil.restapp.services.interfaces.IUniteEtudeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "UniteEtude", description = "L'api des unités d'études")
@RestController
@RequestMapping("/api/unite-etude")
@AllArgsConstructor
public class UniteEtudeController {

    public final IUniteEtudeService uniteEtudeService;

    @PostMapping(value = "/create", produces = "application/json")
    UniteEtudeDto create(@RequestBody UniteEtudeDto uniteEtude) throws Exception {
        return uniteEtudeService.insert(uniteEtude);
    }

    @Operation(
            summary = "Récupérer la liste des unités d'études",
            description = "Retourner la liste de tous les unités d'études")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie") })
    @GetMapping(value = "/list", produces = "application/json")
    List<UniteEtudeDto> list() {
        return uniteEtudeService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    UniteEtudeDto update(@PathVariable Long id, @RequestBody UniteEtudeDto uniteEtudeDto) {
        return uniteEtudeService.update(id, uniteEtudeDto);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    Boolean delete(@PathVariable Long id) {
        return uniteEtudeService.delete(id);
    }
}
