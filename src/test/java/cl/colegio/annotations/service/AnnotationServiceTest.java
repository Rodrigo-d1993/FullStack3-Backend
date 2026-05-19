package cl.colegio.annotations.service;

import cl.colegio.annotations.model.Annotation;
import cl.colegio.annotations.repository.AnnotationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnnotationServiceTest {

    @Mock
    private AnnotationRepository annotationRepository;

    @InjectMocks
    private AnnotationService annotationService;

    @Test
    void getAnnotationsByStudentRut_returnsAnnotations() {
        Annotation annotation = new Annotation();
        annotation.setStudentRut("12345678-9");
        annotation.setDescription("Excelente participación en clases");
        annotation.setType("positive");
        annotation.setDate(LocalDate.of(2024, 5, 18));

        when(annotationRepository.findByStudentRut("12345678-9")).thenReturn(List.of(annotation));

        List<Annotation> result = annotationService.getAnnotationsByStudentRut("12345678-9");

        assertFalse(result.isEmpty());
        assertEquals("positive", result.get(0).getType());
        verify(annotationRepository, times(1)).findByStudentRut("12345678-9");
    }

    @Test
    void createAnnotation_savesAndReturnsAnnotation() {
        Annotation annotation = new Annotation();
        annotation.setStudentRut("12345678-9");
        annotation.setDescription("Excelente participación en clases");
        annotation.setType("positive");
        annotation.setDate(LocalDate.of(2024, 5, 18));

        when(annotationRepository.save(annotation)).thenReturn(annotation);

        Annotation result = annotationService.createAnnotation(annotation);

        assertNotNull(result);
        assertEquals("positive", result.getType());
        verify(annotationRepository, times(1)).save(annotation);
    }

    @Test
    void deleteAnnotation_callsRepository() {
        annotationService.deleteAnnotation(1L);
        verify(annotationRepository, times(1)).deleteById(1L);
    }
}