package com.lab.studentcatalog.demo.model;

public class CourseGrade {
    private Long studentId;  // Cambiado de String a Long
    private String courseCode;
    private double grade;

    // Constructor por defecto
    public CourseGrade() {
    }

    // Constructor con parámetros (actualizado para usar Long)
    public CourseGrade(String courseCode, String courseName, Long studentId, double grade) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.grade = grade;
    }

    // Getters y setters (actualizado para usar Long)
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    // Los otros getters y setters permanecen igual
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}