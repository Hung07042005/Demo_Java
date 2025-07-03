package com.example.demo.service;

import com.example.demo.model.HealthStatusReport;
import com.example.demo.model.Student;
import com.example.demo.repository.HealthStatusReportRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.dto.HealthStatusReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthStatusReportService {
    @Autowired
    private HealthStatusReportRepository reportRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void saveReport(HealthStatusReportDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId()).orElse(null);
        if (student == null) throw new RuntimeException("Student not found");
        HealthStatusReport report = new HealthStatusReport();
        report.setStudent(student);
        report.setReportDate(dto.getReportDate());
        report.setTemperature(dto.getTemperature());
        report.setSymptoms(dto.getSymptoms());
        report.setNotes(dto.getNotes());
        reportRepository.save(report);
    }

    public List<HealthStatusReportDTO> getReportsByStudentId(Long studentId) {
        return reportRepository.findByStudentIdOrderByReportDateDesc(studentId)
            .stream()
            .map(r -> new HealthStatusReportDTO(
                r.getId(),
                r.getStudent().getId(),
                r.getReportDate(),
                r.getTemperature(),
                r.getSymptoms(),
                r.getNotes()
            )).collect(Collectors.toList());
    }
} 