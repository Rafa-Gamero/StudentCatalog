package com.lab.studentcatalog.demo.client;



import com.lab.studentcatalog.demo.dto.CourseDTO;
import com.lab.studentcatalog.demo.dto.CourseGradeDTO;
import com.lab.studentcatalog.demo.dto.GradeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "grades")
public interface GradesClient {

    @GetMapping("/api/course/{courseCode}")
    CourseDTO getCourseByCode(@PathVariable String courseCode);

    @GetMapping("/api/course/{courseCode}/grade")
    CourseGradeDTO getGradesByCourseCode(@PathVariable String courseCode);

    @GetMapping("/api/grade/{id}")
    GradeDTO getGradeById(@PathVariable Long id);
}