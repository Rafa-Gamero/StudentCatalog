package com.lab.studentcatalog.demo.model;

public class CourseGrade {
    private String studentId;
    private String courseCode;
    private double grade;

    // Constructor por defecto
    public CourseGrade() {
    }

    // Constructor con parámetros
    public CourseGrade(String studentId, String courseCode, double grade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
    }

    // Getters y setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

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