package com.example.demo.dto;

import java.time.LocalDate;

public class HealthStatusReportDTO {
    private Long id;
    private Long studentId;
    private LocalDate reportDate;
    private Double temperature;
    private String symptoms;
    private String notes;

    public HealthStatusReportDTO() {}

    public HealthStatusReportDTO(Long id, Long studentId, LocalDate reportDate, Double temperature, String symptoms, String notes) {
        this.id = id;
        this.studentId = studentId;
        this.reportDate = reportDate;
        this.temperature = temperature;
        this.symptoms = symptoms;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public LocalDate getReportDate() { return reportDate; }
    public void setReportDate(LocalDate reportDate) { this.reportDate = reportDate; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
} 