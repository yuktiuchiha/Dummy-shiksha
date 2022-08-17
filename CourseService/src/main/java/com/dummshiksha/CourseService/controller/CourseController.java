package com.dummshiksha.CourseService.controller;

import com.dummshiksha.CourseService.Services.CourseService;
import com.dummshiksha.CourseService.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courseInfo")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Course> CourseByCourseId(@PathVariable("id") int id){
        Optional<Course> response = courseService.CourseByCourseId(id);
        return response;
    }

    @RequestMapping(value = "/all-courses")
    public List<Course> AllCourses(){
        return courseService.AllCourses();
    }

    @RequestMapping(value = "/new-course", method = RequestMethod.POST)
    public String NewCourse(@RequestBody Course course){
        return courseService.NewCourse(course);
    }

    @RequestMapping(value = "courses-by-university/{universityId}", method = RequestMethod.GET)
    public List<Course> CoursesByUniversityId(@PathVariable("universityId") int UID){
        List<Course> courses = courseService.CoursesByUniversityId(UID);
        return courses;
    }

    @RequestMapping(value = "/remove-course/{courseID}", method = RequestMethod.POST)
    public Optional<Course> DeleteCourseByCourseID(@PathVariable("courseID") int id){
        Optional<Course> deletedCourse = courseService.DeleteCourseByCourseID(id);
        return deletedCourse;
    }

}





























//
//    @RequestMapping(value = "/update-course/{fees}/id/{courseId}", method = RequestMethod.PUT)
//    public Optional<Course> UpdateCourseFeesById(@PathVariable("fees") BigDecimal fees , @PathVariable("courseId") int id){
//        Optional<Course> updatedCourse = courseService.UpdateCourseFeesById(fees, id);
//        return updatedCourse;
//    }
