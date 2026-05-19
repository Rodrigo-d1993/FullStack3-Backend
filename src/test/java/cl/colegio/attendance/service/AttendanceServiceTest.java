package cl.colegio.attendance.service;

import cl.colegio.attendance.model.Attendance;
import cl.colegio.attendance.repository.AttendanceRepository;
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
public class AttendanceServiceTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @InjectMocks
    private AttendanceService attendanceService;

    @Test
    void getAttendanceByStudentRut_returnsAttendance() {
        Attendance attendance = new Attendance();
        attendance.setStudentRut("12345678-9");
        attendance.setDate(LocalDate.of(2024, 5, 18));
        attendance.setPresent(true);

        when(attendanceRepository.findByStudentRut("12345678-9")).thenReturn(List.of(attendance));

        List<Attendance> result = attendanceService.getAttendanceByStudentRut("12345678-9");

        assertFalse(result.isEmpty());
        assertTrue(result.get(0).getPresent());
        verify(attendanceRepository, times(1)).findByStudentRut("12345678-9");
    }

    @Test
    void createAttendance_savesAndReturnsAttendance() {
        Attendance attendance = new Attendance();
        attendance.setStudentRut("12345678-9");
        attendance.setDate(LocalDate.of(2024, 5, 18));
        attendance.setPresent(true);

        when(attendanceRepository.save(attendance)).thenReturn(attendance);

        Attendance result = attendanceService.createAttendance(attendance);

        assertNotNull(result);
        assertEquals("12345678-9", result.getStudentRut());
        verify(attendanceRepository, times(1)).save(attendance);
    }

    @Test
    void deleteAttendance_callsRepository() {
        attendanceService.deleteAttendance(1L);
        verify(attendanceRepository, times(1)).deleteById(1L);
    }
}