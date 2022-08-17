package com.dummshiksha.CourseService.Services;

import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.CourseService.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Optional<Course> CourseByCourseId(int id){
        return courseRepository.findById(id);
    }

    public List<Course> AllCourses(){
        return courseRepository.findAll();
    }

//    @Transactional
//    public String NewCourse( Course course){
//        courseRepository.saveCourse(course);
//        return "New course added";
//    }

    @Transactional
    public String NewCourse(Course course){
        courseRepository.saveCourse(course.getUniversityId(), course.getName(), course.getBaseCourse(), course.getFees());
        return "New course added";
    }

    public List<Course> CoursesByUniversityId(int UID){
        List<Course> response = courseRepository.CoursesByUniversityId(UID);
        return response;
    }

    @Transactional
    public Optional<Course> DeleteCourseByCourseID(int id){
        Optional<Course> course = courseRepository.findById(id);
        courseRepository.deleteById(id);
        return course;
    }

    @Transactional
    public Optional<Course> UpdateCourseFeesById(BigDecimal fees, int id){
        Optional<Course> response = courseRepository.UpdateCourseFeesByCourseId(fees, id);
        return response;
    }
}
