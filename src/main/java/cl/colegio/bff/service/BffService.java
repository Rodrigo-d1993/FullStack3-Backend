package cl.colegio.bff.service;

import cl.colegio.annotations.service.AnnotationService;
import cl.colegio.attendance.service.AttendanceService;
import cl.colegio.bff.model.StudentSummary;
import cl.colegio.grades.service.GradeService;
import cl.colegio.students.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class BffService {

    private final StudentService studentService;
    private final GradeService gradeService;
    private final AttendanceService attendanceService;
    private final AnnotationService annotationService;

    public BffService(StudentService studentService, GradeService gradeService,
                      AttendanceService attendanceService, AnnotationService annotationService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
        this.attendanceService = attendanceService;
        this.annotationService = annotationService;
    }

    public StudentSummary getStudentSummary(String rut) {
        StudentSummary summary = new StudentSummary();
        studentService.getStudentByRut(rut).ifPresent(summary::setStudent);
        summary.setGrades(gradeService.getGradesByStudentRut(rut));
        summary.setAttendance(attendanceService.getAttendanceByStudentRut(rut));
        summary.setAnnotations(annotationService.getAnnotationsByStudentRut(rut));
        return summary;
    }
}