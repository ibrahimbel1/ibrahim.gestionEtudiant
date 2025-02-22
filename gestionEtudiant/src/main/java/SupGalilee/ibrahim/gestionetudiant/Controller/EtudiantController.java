package SupGalilee.ibrahim.gestionetudiant.Controller;


import SupGalilee.ibrahim.gestionetudiant.Etudiant.Etudiant;
import SupGalilee.ibrahim.gestionetudiant.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;


    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Optional<Etudiant> getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/statut/{etudiantId}") // pour regarder admis au bien ajourne
    public String getStatutEtudiant(@PathVariable Long etudiantId) {
        return etudiantService.statutEtudiant(etudiantId);
    }

    @GetMapping("/rattrapage/{classeId}")
    public Map<String, Object> getEtudiantsEnRattrapage(@PathVariable Long classeId) {
        return etudiantService.getEtudiantsEnRattrapageParClasse(classeId);
    }

}