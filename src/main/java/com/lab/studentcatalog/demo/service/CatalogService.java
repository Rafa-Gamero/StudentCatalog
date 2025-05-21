package com.lab.studentcatalog.demo.service;

import com.lab.studentcatalog.demo.client.GradesClient;
import com.lab.studentcatalog.demo.client.StudentClient;
import com.lab.studentcatalog.demo.dto.CourseDTO;
import com.lab.studentcatalog.demo.dto.CourseGradeDTO;
import com.lab.studentcatalog.demo.dto.GradeDTO;
import com.lab.studentcatalog.demo.dto.StudentDTO;
import com.lab.studentcatalog.demo.model.Catalog;
import com.lab.studentcatalog.demo.model.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private StudentClient studentInfoServiceClient;

    @Autowired
    private GradesClient gradesDataServiceClient;

    // Cambiado de Long a String para el courseCode
    public Catalog getCatalogByCourseCode(String courseCode) {
        // Obtenemos la información del curso
        CourseDTO course = gradesDataServiceClient.getCourseByCode(courseCode);

        if (course == null) {
            return null;
        }

        // Obtenemos las calificaciones del curso
        CourseGradeDTO courseGrade = gradesDataServiceClient.getGradesByCourseCode(courseCode);

        List<StudentGrade> studentGrades = new ArrayList<>();

        if (courseGrade != null && courseGrade.getGrades() != null) {
            for (GradeDTO grade : courseGrade.getGrades()) {
                // Obtenemos la información del estudiante
                StudentDTO student = studentInfoServiceClient.getStudentId(grade.getStudentId());

                if (student != null) {
                    studentGrades.add(new StudentGrade(
                            student.getStudentName(),
                            student.getStudentAge(),
                            grade.getGrade()
                    ));
                }
            }
        }

        return new Catalog(course.getCourseName(), studentGrades);
    }
}