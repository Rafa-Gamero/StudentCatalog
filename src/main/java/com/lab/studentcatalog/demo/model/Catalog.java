package com.lab.studentcatalog.demo.model;

import java.util.List;

public class Catalog {
    private String courseName;
    private List<StudentGrade> studentGrades;

    // Constructor por defecto
    public Catalog() {
    }

    // Constructor con parámetros
    public Catalog(String courseName, List<StudentGrade> studentGrades) {
        this.courseName = courseName;
        this.studentGrades = studentGrades;
    }

    // Getters y setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }
}