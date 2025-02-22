package SupGalilee.ibrahim.gestionetudiant.Service;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Filiere;
import SupGalilee.ibrahim.gestionetudiant.Repository.FiliereRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }
}