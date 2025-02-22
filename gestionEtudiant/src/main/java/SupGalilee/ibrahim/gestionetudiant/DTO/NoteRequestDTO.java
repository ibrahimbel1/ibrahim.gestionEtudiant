package SupGalilee.ibrahim.gestionetudiant.DTO;


import lombok.Data;
import java.util.List;

@Data
public class NoteRequestDTO {
    private Long IDC;
    private List<NoteDTO> notes;
}
