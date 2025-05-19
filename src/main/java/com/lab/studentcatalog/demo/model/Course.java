package com.lab.studentcatalog.demo.model;

public class Course {
    private String courseCode;
    private String courseName;

    // Constructor por defecto
    public Course() {
    }

    // Constructor con parámetros
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    // Getters y setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}