package com.lab.studentcatalog.demo.controller;


import com.lab.studentcatalog.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/course/{courseCode}")
    public ResponseEntity<Catalog> getStudentCatalogByCourse(@PathVariable String courseCode) {
        // 1. Obtener el curso por código
        Course course = restTemplate.getForObject("http://grades-data-service/courses/" + courseCode, Course.class);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        // 2. Obtener las notas de los estudiantes para este curso
        CourseGrade[] courseGrades = restTemplate.getForObject("http://grades-data-service/courses/" + courseCode + "/grades", CourseGrade[].class);

        if (courseGrades == null || courseGrades.length == 0) {
            return ResponseEntity.notFound().build();
        }

        // 3. Para cada nota, obtener la información del estudiante correspondiente
        List<StudentGrade> studentGrades = Arrays.stream(courseGrades)
                .map(cg -> {
                    Student student = restTemplate.getForObject("http://student-info-service/students/" + cg.getStudentId(), Student.class);
                    if (student != null) {
                        return new StudentGrade(student.getName(), student.getAge(), cg.getGrade());
                    }
                    return null;
                })
                .filter(sg -> sg != null)
                .collect(Collectors.toList());

        // 4. Crear y devolver el catálogo
        Catalog catalog = new Catalog(course.getCourseName(), studentGrades);
        return ResponseEntity.ok(catalog);
    }
}