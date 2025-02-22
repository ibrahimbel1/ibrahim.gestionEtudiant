package SupGalilee.ibrahim.gestionetudiant.DTO;

import lombok.Data;

@Data
public class NoteDTO {
    private Long idMatiere;
    private Long idEtudiant;
    private double valeur;
}