package com.lab.studentcatalog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseGradeDTO {
    private String courseName;
    private List<GradeDTO> grades;
}
