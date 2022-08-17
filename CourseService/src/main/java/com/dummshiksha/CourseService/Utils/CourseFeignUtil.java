package com.dummshiksha.CourseService.Utils;


import com.dummshiksha.CourseService.models.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "CourseService", url = "${course.service.url}")
public interface CourseFeignUtil {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Course> CourseByCourseId(@PathVariable("id") int id);

    @RequestMapping(value = "/all=courses", method = RequestMethod.GET)
    List<Course> AllCourses();

    @RequestMapping(value = "course-by-university/{universityId)", method = RequestMethod.GET)
    List<Course> CoursebyUniversityId(@PathVariable("universityId") int UID);

    @RequestMapping(value = "/new-course", method = RequestMethod.POST)
    String NewCourse(@RequestBody Course course);

    @RequestMapping(value = "/remove-course/{courseID}", method = RequestMethod.POST)
    Optional<Course> DeleteCourseByCourseID(@PathVariable("courseID") int id);
}
