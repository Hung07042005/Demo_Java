package com.example.demo.repository;

import com.example.demo.model.HealthStatusReport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HealthStatusReportRepository extends JpaRepository<HealthStatusReport, Long> {
    List<HealthStatusReport> findByStudentIdOrderByReportDateDesc(Long studentId);
} 