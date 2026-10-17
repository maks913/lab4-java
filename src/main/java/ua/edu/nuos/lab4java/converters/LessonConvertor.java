package ua.edu.nuos.lab4java.converters;

import ua.edu.nuos.lab4java.data.Lesson;
import ua.edu.nuos.lab4java.dto.LessonDto;

public class LessonConvertor {

    private final SubjectConvertor subjectConvertor = new SubjectConvertor();
    private final ProfessorConvertor professorConvertor = new ProfessorConvertor();

    public Lesson convert(LessonDto lessonDto) {
        Lesson lesson = new Lesson();

        lesson.setId(lessonDto.getId());
        lesson.setClassroom(lessonDto.getClassroom());
        lesson.setQuantityStudents(lessonDto.getQuantityStudents());
        lesson.setSubject(subjectConvertor.convert(lessonDto.getSubject()));
        lesson.setProfessor(professorConvertor.convert(lessonDto.getProfessor()));
        lesson.setTimeEvent(lessonDto.getTimeEvent());
        lesson.setPairNumber(lessonDto.getPairNumber());

        return lesson;
    }

    public LessonDto convert(Lesson lesson) {
        LessonDto l = new LessonDto();

        l.setId(lesson.getId());
        l.setClassroom(lesson.getClassroom());
        l.setTimeEvent(lesson.getTimeEvent());
        l.setPairNumber(lesson.getPairNumber());
        l.setQuantityStudents(lesson.getQuantityStudents());
        l.setSubject(subjectConvertor.convert(lesson.getSubject()));
        l.setProfessor(professorConvertor.convert(lesson.getProfessor()));
        return l;
    }

}
