package com.academetrics.backend.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    public String course_id;
    public String course_name;
    public String faculty;
    public String department;
    @Nullable
    public String description;
}
