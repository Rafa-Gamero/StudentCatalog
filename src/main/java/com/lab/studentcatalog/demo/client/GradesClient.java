package com.lab.studentcatalog.demo.client;



import com.lab.studentcatalog.demo.model.Course;
import com.lab.studentcatalog.demo.model.CourseGrade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "grades")
public interface GradesClient {

    @GetMapping("/courses/{courseCode}")
    Course getCourseByCode(@PathVariable("courseCode") String courseCode);

    @GetMapping("/courses/{courseCode}/grades")
    List<CourseGrade> getGradesByCourseCode(@PathVariable("courseCode") String courseCode);
}