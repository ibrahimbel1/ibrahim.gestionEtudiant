package SupGalilee.ibrahim.gestionetudiant.Controller;

import SupGalilee.ibrahim.gestionetudiant.DTO.NoteRequestDTO;
import SupGalilee.ibrahim.gestionetudiant.Etudiant.Note;
import SupGalilee.ibrahim.gestionetudiant.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    @GetMapping("/moyenne/{etudiantId}")
    public double getMoyenneEtudiant(@PathVariable Long etudiantId) {
        return noteService.calculerMoyenneEtudiant(etudiantId);
    }

    @PostMapping("/ajouter-liste")
    public void ajouterListeNotes(@RequestBody NoteRequestDTO noteRequest) {
        noteService.ajouterListeNotes(noteRequest);
    }



}