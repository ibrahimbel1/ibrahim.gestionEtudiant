package SupGalilee.ibrahim.gestionetudiant.Controller;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Matiere;
import SupGalilee.ibrahim.gestionetudiant.Service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/matieres")
public class MatiereController {
    @Autowired
    private MatiereService matiereService;

    @GetMapping
    public List<Matiere> getAllMatieres() {
        return matiereService.getAllMatieres();
    }

    @PostMapping
    public Matiere createMatiere(@RequestBody Matiere matiere) {
        return matiereService.saveMatiere(matiere);
    }

    @DeleteMapping("/{id}")
    public void deleteMatiere(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
    }
}