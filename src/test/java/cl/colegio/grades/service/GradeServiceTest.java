package cl.colegio.grades.service;

import cl.colegio.grades.model.Grade;
import cl.colegio.grades.repository.GradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    void getGradesByStudentRut_returnsGrades() {
        Grade grade = new Grade();
        grade.setStudentRut("12345678-9");
        grade.setSubject("Matemáticas");
        grade.setScore(6.5);
        grade.setPeriod("1er semestre");

        when(gradeRepository.findByStudentRut("12345678-9")).thenReturn(List.of(grade));

        List<Grade> result = gradeService.getGradesByStudentRut("12345678-9");

        assertFalse(result.isEmpty());
        assertEquals("Matemáticas", result.get(0).getSubject());
        verify(gradeRepository, times(1)).findByStudentRut("12345678-9");
    }

    @Test
    void createGrade_savesAndReturnsGrade() {
        Grade grade = new Grade();
        grade.setStudentRut("12345678-9");
        grade.setSubject("Matemáticas");
        grade.setScore(6.5);
        grade.setPeriod("1er semestre");

        when(gradeRepository.save(grade)).thenReturn(grade);

        Grade result = gradeService.createGrade(grade);

        assertNotNull(result);
        assertEquals(6.5, result.getScore());
        verify(gradeRepository, times(1)).save(grade);
    }

    @Test
    void deleteGrade_callsRepository() {
        gradeService.deleteGrade(1L);
        verify(gradeRepository, times(1)).deleteById(1L);
    }
}