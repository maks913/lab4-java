package ua.edu.nuos.lab4java.service;

import org.springframework.stereotype.Service;
import ua.edu.nuos.lab4java.converters.SubjectConvertor;
import ua.edu.nuos.lab4java.dto.SubjectDto;
import ua.edu.nuos.lab4java.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectConvertor subjectConvertor = new SubjectConvertor();

    private final SubjectRepository subjectRepository;

    SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectDto> getSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectConvertor::convert)
                .toList();
    }

}
