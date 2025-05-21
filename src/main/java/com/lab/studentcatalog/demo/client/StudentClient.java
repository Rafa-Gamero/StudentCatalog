package com.lab.studentcatalog.demo.client;

import com.lab.studentcatalog.demo.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-info-service")
public interface StudentClient {

    @GetMapping("/api/student/{studentId}")
    StudentDTO getStudentId(@PathVariable Long studentId);
    }

