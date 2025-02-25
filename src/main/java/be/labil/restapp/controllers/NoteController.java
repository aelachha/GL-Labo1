package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.ShortNoteDTO;
import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.services.interfaces.INoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Note", description = "L'api des notes")
@RestController
@RequestMapping("/api/note")
@AllArgsConstructor
public class NoteController {

    public final INoteService noteService;

    @PostMapping(value = "/create", produces = "application/json")
    NoteDto create(@RequestBody ShortNoteDTO noteDto) {

        return noteService.insert(noteDto);
    }

    @Operation(
            summary = "Récupérer la liste des notes",
            description = "Retourner la liste de tous les notes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie") })
    @GetMapping(value = "/list", produces = "application/json")
    List<NoteDto> list() {
        return noteService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    NoteDto update(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        return noteService.update(id, noteDto);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    Boolean delete(@PathVariable Long id) {
        return noteService.delete(id);
    }
}
