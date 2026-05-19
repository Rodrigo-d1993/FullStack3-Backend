package cl.colegio.bff.model;

import cl.colegio.annotations.model.Annotation;
import cl.colegio.attendance.model.Attendance;
import cl.colegio.grades.model.Grade;
import cl.colegio.students.model.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentSummary {
    private Student student;
    private List<Grade> grades;
    private List<Attendance> attendance;
    private List<Annotation> annotations;
}