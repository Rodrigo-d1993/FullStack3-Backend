package cl.colegio.grades.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentRut;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private String period; // ej: "1er semestre", "2do semestre"
}