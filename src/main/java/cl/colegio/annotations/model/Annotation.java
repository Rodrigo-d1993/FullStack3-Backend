package cl.colegio.annotations.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "annotations")
public class Annotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentRut;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type; // "positive" o "negative"

    @Column(nullable = false)
    private LocalDate date;
}