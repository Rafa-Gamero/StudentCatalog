package com.lab.studentcatalog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradeDTO {
    private Long gradeId;
    private Double grade;
    private Long studentId;
}