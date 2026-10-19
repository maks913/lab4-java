package ua.edu.nuos.lab4java.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.lab4java.converters.SubjectConvertor;
import ua.edu.nuos.lab4java.dto.SubjectDto;
import ua.edu.nuos.lab4java.repository.SubjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {

    private final SubjectConvertor subjectConvertor = new SubjectConvertor();
    private final SubjectRepository subjectRepository;

    public List<SubjectDto> getSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectConvertor::convert)
                .toList();
    }

}
