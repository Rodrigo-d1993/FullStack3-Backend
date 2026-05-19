package cl.colegio.bff.controller;

import cl.colegio.bff.model.StudentSummary;
import cl.colegio.bff.service.BffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bff")
public class BffController {

    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/student/{rut}")
    public ResponseEntity<StudentSummary> getStudentSummary(@PathVariable String rut) {
        return ResponseEntity.ok(bffService.getStudentSummary(rut));
    }
}