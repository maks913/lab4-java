package ua.edu.nuos.lab4java.converters;

import ua.edu.nuos.lab4java.data.Professor;
import ua.edu.nuos.lab4java.dto.ProfessorDto;

public class ProfessorConvertor {

    public Professor convert(ProfessorDto professorDto) {
        Professor professor = new Professor();
        professor.setId(professorDto.getId());
        professor.setFullName(professorDto.getFullName());
        return professor;
    }

    public ProfessorDto convert(Professor professor) {
        ProfessorDto p = new ProfessorDto();
        p.setId(professor.getId());
        p.setFullName(professor.getFullName());
        return p;
    }
}
