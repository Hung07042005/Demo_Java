package com.example.demo.dto;

import java.time.LocalDate;

public class VaccinationDTO {
    private String vaccineName;
    private LocalDate vaccinationDate;
    private String notes;

    public VaccinationDTO() {}

    public VaccinationDTO(String vaccineName, LocalDate vaccinationDate, String notes) {
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
        this.notes = notes;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
} 