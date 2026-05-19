package cl.colegio.annotations.controller;

import cl.colegio.annotations.model.Annotation;
import cl.colegio.annotations.service.AnnotationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annotations")
public class AnnotationController {

    private final AnnotationService annotationService;

    public AnnotationController(AnnotationService annotationService) {
        this.annotationService = annotationService;
    }

    @GetMapping("/{studentRut}")
    public List<Annotation> getAnnotationsByStudentRut(@PathVariable String studentRut) {
        return annotationService.getAnnotationsByStudentRut(studentRut);
    }

    @PostMapping
    public ResponseEntity<Annotation> createAnnotation(@RequestBody Annotation annotation) {
        return ResponseEntity.ok(annotationService.createAnnotation(annotation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnotation(@PathVariable Long id) {
        annotationService.deleteAnnotation(id);
        return ResponseEntity.noContent().build();
    }
}