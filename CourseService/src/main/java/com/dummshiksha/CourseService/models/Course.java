package com.dummshiksha.CourseService.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Entity
@Table(name = "courses")
public class Course {

    @GeneratedValue
    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "university_id")
    private int universityId;

    @Column(name = "name")
    private String name;

    @Column(name = "base_course")
    private String baseCourse;

    @Column(name = "fees")
    private BigDecimal fees;

    public Course() {

    }

    public Course(int courseId, int universityId, String name, String baseCourse, BigDecimal fees) {
        this.courseId = courseId;
        this.universityId = universityId;
        this.name = name;
        this.baseCourse = baseCourse;
        this.fees = fees;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseCourse() {
        return baseCourse;
    }

    public void setBaseCourse(String baseCourse) {
        this.baseCourse = baseCourse;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }
}

//CREATE TABLE courses ( course_id int(10) NOT NULL AUTO_INCREMENT, name varchar(100) NOT NULL, base_course varchar(100) NOT NULL, fees int(10) NOT NULL created_by varchar(100) NOT NULL, created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, updated_by varchar(100) NOT NULL, updated_on timestamp NOT NULL;