package com.lab.studentcatalog.demo.client;

import com.lab.studentcatalog.demo.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-info-service")
public interface StudentClient {

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable("id") Long id);

    // Método adicional para manejar la conversión
    default Student getStudentByStringId(String id) {
        return getStudentById(Long.parseLong(id));
    }
}
