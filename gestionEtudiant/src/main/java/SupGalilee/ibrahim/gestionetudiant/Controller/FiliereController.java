package SupGalilee.ibrahim.gestionetudiant.Controller;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Filiere;
import SupGalilee.ibrahim.gestionetudiant.Service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filieres")
public class FiliereController {
    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereService.saveFiliere(filiere);
    }

    @DeleteMapping("/{id}")
    public void deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
    }
}