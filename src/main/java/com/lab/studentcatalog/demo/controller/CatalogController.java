package com.lab.studentcatalog.demo.controller;

import com.lab.studentcatalog.demo.client.GradesClient;
import com.lab.studentcatalog.demo.client.StudentClient;
import com.lab.studentcatalog.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private GradesClient gradesClient;

    @Autowired
    private StudentClient studentClient;

    // En CatalogController.java
    @GetMapping("/course/{courseCode}")
    public ResponseEntity<Catalog> getStudentCatalogByCourse(@PathVariable String courseCode) {
        // 1. Obtener el curso por código
        Course course = gradesClient.getCourseByCode(courseCode);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        // 2. Obtener las notas de los estudiantes para este curso
        List<CourseGrade> courseGrades = gradesClient.getGradesByCourseCode(courseCode);

        if (courseGrades == null || courseGrades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 3. Para cada nota, obtener la información del estudiante correspondiente
        List<StudentGrade> studentGrades = courseGrades.stream()
                .map(cg -> {
                    if (cg.getStudentId() != null) {
                        Student student = studentClient.getStudentById(cg.getStudentId());
                        if (student != null) {
                            return new StudentGrade(student.getName(), student.getAge(), cg.getGrade());
                        }
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