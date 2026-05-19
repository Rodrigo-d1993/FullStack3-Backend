package cl.colegio.annotations.service;

import cl.colegio.annotations.model.Annotation;
import cl.colegio.annotations.repository.AnnotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationService {

    private final AnnotationRepository annotationRepository;

    public AnnotationService(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }

    public List<Annotation> getAnnotationsByStudentRut(String studentRut) {
        return annotationRepository.findByStudentRut(studentRut);
    }

    public Annotation createAnnotation(Annotation annotation) {
        return annotationRepository.save(annotation);
    }

    public void deleteAnnotation(Long id) {
        annotationRepository.deleteById(id);
    }
}