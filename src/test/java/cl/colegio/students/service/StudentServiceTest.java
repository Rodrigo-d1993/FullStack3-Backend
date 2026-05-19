package cl.colegio.students.service;

import cl.colegio.students.model.Student;
import cl.colegio.students.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void getStudentByRut_returnsStudent() {
        Student student = new Student();
        student.setRut("12345678-9");
        student.setFirstName("Juan");
        student.setLastName("Pérez");
        student.setGrade("1°A");

        when(studentRepository.findByRut("12345678-9")).thenReturn(Optional.of(student));

        Optional<Student> result = studentService.getStudentByRut("12345678-9");

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getFirstName());
        verify(studentRepository, times(1)).findByRut("12345678-9");
    }

    @Test
    void createStudent_savesAndReturnsStudent() {
        Student student = new Student();
        student.setRut("12345678-9");
        student.setFirstName("Juan");
        student.setLastName("Pérez");
        student.setGrade("1°A");

        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.createStudent(student);

        assertNotNull(result);
        assertEquals("12345678-9", result.getRut());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void deleteStudent_callsRepository() {
        studentService.deleteStudent(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }
}