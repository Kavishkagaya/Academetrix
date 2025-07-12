package com.academetrics.backend.Services;

import com.academetrics.backend.DTO.CourseDTO.CourseNameDTO;
import com.academetrics.backend.Models.Course;
import com.academetrics.backend.Repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper){
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public List<CourseNameDTO> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        courses.forEach(course -> {
            System.out.print(course.course_id);
        });
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseNameDTO.class))
                .collect(Collectors.toList());
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
}
