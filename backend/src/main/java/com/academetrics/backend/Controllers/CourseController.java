package com.academetrics.backend.Controllers;

import com.academetrics.backend.DTO.CourseDTO.CourseNameDTO;
import com.academetrics.backend.Models.Course;
import com.academetrics.backend.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/")
    public List<CourseNameDTO> getCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }
}
