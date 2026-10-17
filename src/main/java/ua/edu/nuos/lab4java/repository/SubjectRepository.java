package ua.edu.nuos.lab4java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.lab4java.data.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}