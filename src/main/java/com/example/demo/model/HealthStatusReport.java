package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "health_status_reports")
public class HealthStatusReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private LocalDate reportDate;
    private Double temperature;
    private String symptoms;
    private String notes;

    public HealthStatusReport() {}

    public HealthStatusReport(Student student, LocalDate reportDate, Double temperature, String symptoms, String notes) {
        this.student = student;
        this.reportDate = reportDate;
        this.temperature = temperature;
        this.symptoms = symptoms;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public LocalDate getReportDate() { return reportDate; }
    public void setReportDate(LocalDate reportDate) { this.reportDate = reportDate; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
} 