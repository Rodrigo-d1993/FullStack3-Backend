package cl.colegio.attendance.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentRut;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Boolean present;
}