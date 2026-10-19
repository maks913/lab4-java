package ua.edu.nuos.lab4java.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.nuos.lab4java.converters.LessonConvertor;
import ua.edu.nuos.lab4java.dto.LessonDto;
import ua.edu.nuos.lab4java.repository.LessonRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonService {
    private final LessonConvertor lessonConvertor = new LessonConvertor();
    private final LessonRepository lessonRepository;

    public List<LessonDto> getLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(lessonConvertor::convert)
                .toList();
    }

    @Transactional
    public void saveLesson(LessonDto lessonDto) {
        lessonRepository.save(lessonConvertor.convert(lessonDto));
    }

    @Transactional
    public void deleteById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Lesson id cannot be null");
        lessonRepository.deleteById(id);
    }

    @Transactional
    public LessonDto findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Lesson id cannot be null");
        return lessonRepository.findById(id)
                .map(lessonConvertor::convert)
                .orElse(null);
    }
}
