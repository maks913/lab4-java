package ua.edu.nuos.lab4java.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professor", schema = "demo_db")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id", nullable = false)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

}