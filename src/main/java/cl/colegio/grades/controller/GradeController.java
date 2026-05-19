package cl.colegio.grades.controller;

import cl.colegio.grades.model.Grade;
import cl.colegio.grades.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/{studentRut}")
    public List<Grade> getGradesByStudentRut(@PathVariable String studentRut) {
        return gradeService.getGradesByStudentRut(studentRut);
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.createGrade(grade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}