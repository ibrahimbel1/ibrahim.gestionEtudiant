package SupGalilee.ibrahim.gestionetudiant.Service;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Matiere;
import SupGalilee.ibrahim.gestionetudiant.Repository.MatiereRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;

    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public void deleteMatiere(Long id) {
        matiereRepository.deleteById(id);
    }
}