package ua.edu.nuos.lab4java.service;

import org.springframework.stereotype.Service;
import ua.edu.nuos.lab4java.converters.ProfessorConvertor;
import ua.edu.nuos.lab4java.dto.ProfessorDto;
import ua.edu.nuos.lab4java.repository.ProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorConvertor profConvertor = new ProfessorConvertor();
    private final ProfessorRepository professorRepository;

    ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorDto> getProfessors() {
        return professorRepository.findAll()
                .stream()
                .map(profConvertor::convert)
                .toList();
    }
}
