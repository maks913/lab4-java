package ua.edu.nuos.lab4java.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "lesson", schema = "demo_db")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "pair_number", nullable = false)
    private Integer pairNumber;

    @NotNull
    @Column(name = "quantity_students", nullable = false)
    private Integer quantityStudents;

    @Size(max = 20)
    @NotNull
    @Column(name = "time_event", nullable = false, length = 20)
    private String timeEvent;

    @Size(max = 25)
    @NotNull
    @Column(name = "classroom", nullable = false, length = 25)
    private String classroom;

}