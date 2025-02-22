package SupGalilee.ibrahim.gestionetudiant.Service;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Etudiant;
import SupGalilee.ibrahim.gestionetudiant.Etudiant.Note;
import SupGalilee.ibrahim.gestionetudiant.Repository.EtudiantRepository;
import SupGalilee.ibrahim.gestionetudiant.Repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.*;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public String statutEtudiant(Long etudiantId) {
        double moyenne = noteService.calculerMoyenneEtudiant(etudiantId);
        return (moyenne >= 10) ? "Admis" : "Ajourné";
    }

    public Map<String, Object> getEtudiantsEnRattrapageParClasse(Long classeId) {
    List<Etudiant> etudiants = etudiantRepository.findByClasseId(classeId);
    List<Map<String, Object>> etudiantsRattrapage = new ArrayList<>();

    for (Etudiant etudiant : etudiants) {
        double moyenne = noteService.calculerMoyenneEtudiant(etudiant.getId());

        if (moyenne < 10) {
            List<Note> notes = noteRepository.findByEtudiantId(etudiant.getId());

            for (Note note : notes) {
                if (note.getValeur() < 10) {
                    Map<String, Object> etudiantData = new HashMap<>();
                    etudiantData.put("idEtudiant", etudiant.getId());
                    etudiantData.put("nom", etudiant.getNom());
                    etudiantData.put("matiere", note.getMatiere().getNom());
                    etudiantData.put("note", note.getValeur());

                    etudiantsRattrapage.add(etudiantData);
                }
            }
        }
    }

    Map<String, Object> response = new HashMap<>();
    response.put("IDC", classeId);
    response.put("etudiantsEnRattrapage", etudiantsRattrapage);

    return response;
}

}
