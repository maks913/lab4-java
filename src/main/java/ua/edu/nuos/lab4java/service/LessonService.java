package ua.edu.nuos.lab4java.service;

import org.springframework.stereotype.Service;
import ua.edu.nuos.lab4java.converters.LessonConvertor;
import ua.edu.nuos.lab4java.dto.LessonDto;
import ua.edu.nuos.lab4java.repository.LessonRepository;

import java.util.List;

@Service
public class LessonService {
    private final LessonConvertor lessonConvertor = new LessonConvertor();
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<LessonDto> getLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(lessonConvertor::convert)
                .toList();
    }

    public void saveLesson(LessonDto lessonDto) {
        lessonRepository.save(lessonConvertor.convert(lessonDto));
    }

    public void deleteById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Lesson id cannot be null");
        lessonRepository.deleteById(id);
    }

    public LessonDto findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Lesson id cannot be null");
        return lessonRepository.findById(id)
                .map(lessonConvertor::convert)
                .orElse(null);
    }
}
