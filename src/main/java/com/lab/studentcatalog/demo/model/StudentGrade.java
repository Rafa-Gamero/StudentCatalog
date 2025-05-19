package com.lab.studentcatalog.demo.model;

public class StudentGrade {
    private String studentName;
    private int studentAge;
    private double grade;

    // Constructor por defecto
    public StudentGrade() {
    }

    // Constructor con parámetros
    public StudentGrade(String studentName, int studentAge, double grade) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.grade = grade;
    }

    // Getters y setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
