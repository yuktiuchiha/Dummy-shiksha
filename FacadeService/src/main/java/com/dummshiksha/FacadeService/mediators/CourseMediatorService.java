package com.dummshiksha.FacadeService.mediators;

import com.dummshiksha.CourseService.Utils.CourseFeignUtil;
import com.dummshiksha.CourseService.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
public class CourseMediatorService {

    @Autowired
    private CourseFeignUtil courseFeignUtil;

    public Mono<Optional<Course>> courseByID(int CID){
        return Mono.fromCallable(()->courseFeignUtil.CourseByCourseId(CID));
    }

    public Flux<Course> allCourses(){
        return (Flux<Course>) courseFeignUtil.AllCourses();
    }

    public String newCourse(Course course){
        return courseFeignUtil.NewCourse(course);
    }

    public Mono<Optional<Course>> deleteCourseById(int CID){
        return Mono.fromCallable(()->courseFeignUtil.DeleteCourseByCourseID(CID));
    }

}
