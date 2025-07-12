package com.academetrics.backend.Repositories;

import com.academetrics.backend.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
