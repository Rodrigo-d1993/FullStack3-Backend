package cl.colegio.grades.service;

import cl.colegio.grades.model.Grade;
import cl.colegio.grades.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getGradesByStudentRut(String studentRut) {
        return gradeRepository.findByStudentRut(studentRut);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}