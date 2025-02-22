package SupGalilee.ibrahim.gestionetudiant.Controller;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Classe;
import SupGalilee.ibrahim.gestionetudiant.Service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe) {
        return classeService.saveClasse(classe);
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
    }
}