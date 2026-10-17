package ua.edu.nuos.lab4java.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto implements Serializable {
    Integer id;

    @Size(max = 255)
    String name;
}