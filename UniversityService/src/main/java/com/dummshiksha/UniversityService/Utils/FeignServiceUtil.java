package com.dummshiksha.UniversityService.Utils;

import com.dummshiksha.CourseService.models.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "CourseService", url = "http://localhost:8081/courseInfo/")
public interface FeignServiceUtil {

    @GetMapping("courses-by-university/{universityId}")
    List<Course>  CoursesUByUniversityId(@PathVariable("universityId") int id);


}
