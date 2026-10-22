package ua.edu.nuos.lab4java.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.nuos.lab4java.dto.LessonDto;
import ua.edu.nuos.lab4java.dto.ProfessorDto;
import ua.edu.nuos.lab4java.dto.SubjectDto;
import ua.edu.nuos.lab4java.service.LessonService;
import ua.edu.nuos.lab4java.service.ProfessorService;
import ua.edu.nuos.lab4java.service.SubjectService;

import java.util.List;

@Controller
@RequestMapping("/lesson")
@AllArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final SubjectService subjectService;
    private final ProfessorService professorService;

    @GetMapping
    public String getLessons(Model model) {
        List<LessonDto> lessonDtoList = lessonService.getLessons();
        List<SubjectDto> subjectDtoList = subjectService.getSubjects();
        List<ProfessorDto> professorDtoList = professorService.getProfessors();

        model.addAttribute("lesson", new LessonDto());
        model.addAttribute("lessonEdit", new LessonDto());
        model.addAttribute("lessonDtoList", lessonDtoList);
        model.addAttribute("subjectDtoList", subjectDtoList);
        model.addAttribute("professorDtoList", professorDtoList);
        return "lesson";
    }

    @PostMapping("/save")
    public String createLesson(@ModelAttribute LessonDto lessonDto) {
        lessonService.saveLesson(lessonDto);
        return "redirect:/lesson";
    }

    @PostMapping("/update")
    public String updateLesson(@ModelAttribute LessonDto lessonDto) {
        if (lessonDto.getId() == null) {
            throw new RuntimeException("Lesson ID is null");
        }
        lessonService.saveLesson(lessonDto);
        return "redirect:/lesson";
    }

    @PostMapping("/delete/{id}")
    public String deleteLesson(@PathVariable Integer id) {
        lessonService.deleteById(id);
        return "redirect:/lesson";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<LessonDto> findById(@PathVariable Integer id) {
        LessonDto response = lessonService.findById(id);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        };
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
