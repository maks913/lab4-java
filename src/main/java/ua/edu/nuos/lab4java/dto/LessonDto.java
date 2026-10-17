package ua.edu.nuos.lab4java.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LessonDto implements Serializable {
    Integer id;

    @NotNull
    @Size(max = 20)
    String timeEvent;

    @NotNull
    @Size(max = 20)
    String classroom;

    @NotNull
    Integer quantityStudents;

    @NotNull
    Integer pairNumber;

    ProfessorDto professor;
    SubjectDto subject;
}