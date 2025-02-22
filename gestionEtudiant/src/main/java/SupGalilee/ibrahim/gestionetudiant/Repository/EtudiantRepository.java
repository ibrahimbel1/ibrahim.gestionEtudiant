package SupGalilee.ibrahim.gestionetudiant.Repository;


import SupGalilee.ibrahim.gestionetudiant.Etudiant.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByClasseId(Long classeId);
}
