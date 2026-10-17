package ua.edu.nuos.lab4java.converters;

import ua.edu.nuos.lab4java.data.Subject;
import ua.edu.nuos.lab4java.dto.SubjectDto;

public class SubjectConvertor {

    public Subject convert(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        return subject;
    }

    public SubjectDto convert(Subject subject) {
        SubjectDto s = new SubjectDto();
        s.setId(subject.getId());
        s.setName(subject.getName());
        return s;
    }
}
