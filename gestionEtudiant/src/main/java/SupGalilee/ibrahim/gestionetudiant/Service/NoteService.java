package SupGalilee.ibrahim.gestionetudiant.Service;

import SupGalilee.ibrahim.gestionetudiant.DTO.NoteDTO;
import SupGalilee.ibrahim.gestionetudiant.DTO.NoteRequestDTO;
import SupGalilee.ibrahim.gestionetudiant.Etudiant.Etudiant;
import SupGalilee.ibrahim.gestionetudiant.Etudiant.Matiere;
import SupGalilee.ibrahim.gestionetudiant.Etudiant.Note;
import SupGalilee.ibrahim.gestionetudiant.Repository.EtudiantRepository;
import SupGalilee.ibrahim.gestionetudiant.Repository.MatiereRepository;
import SupGalilee.ibrahim.gestionetudiant.Repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private MatiereRepository matiereRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
    public double calculerMoyenneEtudiant(Long etudiantId) {
        List<Note> notes = noteRepository.findByEtudiantId(etudiantId);

        if (notes.isEmpty()) {
            return 0.0;
        }

        double somme = notes.stream().mapToDouble(Note::getValeur).sum();
        return somme / notes.size();
    }


    public void ajouterListeNotes(NoteRequestDTO noteRequest) {
        for (NoteDTO noteDto : noteRequest.getNotes()) {
            Optional<Etudiant> etudiantOpt = etudiantRepository.findById(noteDto.getIdEtudiant());
            Optional<Matiere> matiereOpt = matiereRepository.findById(noteDto.getIdMatiere());

            if (etudiantOpt.isPresent() && matiereOpt.isPresent()) {
                Note note = new Note();
                note.setEtudiant(etudiantOpt.get());
                note.setMatiere(matiereOpt.get());
                note.setValeur(noteDto.getValeur());
                noteRepository.save(note);
            }
        }
    }

}