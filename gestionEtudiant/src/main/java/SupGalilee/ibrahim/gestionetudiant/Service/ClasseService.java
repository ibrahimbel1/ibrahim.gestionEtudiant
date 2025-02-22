package SupGalilee.ibrahim.gestionetudiant.Service;

import SupGalilee.ibrahim.gestionetudiant.Etudiant.Classe;
import SupGalilee.ibrahim.gestionetudiant.Repository.ClasseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}