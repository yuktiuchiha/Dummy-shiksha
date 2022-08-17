package com.dummshiksha.FacadeService.Controller;


import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.FacadeService.Service.AggregateService;
import com.dummshiksha.UniversityService.models.University;
import com.dummshiksha.UserService.models.User;
import loginDTO.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class FacadeController {

    @Autowired
    private AggregateService aggregateService;

    @RequestMapping(value = "/university/{id}", method = RequestMethod.GET)
    public Mono<Optional<University>> universityById(@PathVariable("id") int UID){
        return aggregateService.universityById(UID);
    }

    @RequestMapping(value = "/university/all", method = RequestMethod.GET)
    public Flux<University> allUniversity(){
        return aggregateService.allUniversity();
    }

    @RequestMapping(value = "/new-university", method = RequestMethod.POST)
    public String newUniversity(@RequestBody University university){
        return aggregateService.newUniversity(university);
    }

    @RequestMapping(value = "/remove-university/{id}", method = RequestMethod.POST)
    public Mono<Optional<University>> deleteUniversityById(@PathVariable("id") int UID){
        return aggregateService.deleteUniversityById(UID);
    }

    @RequestMapping(value = "/university-courses/{id}", method = RequestMethod.GET)
    public Flux<Course> coursesByUniversity(@PathVariable("id") int UID){
        return aggregateService.coursesByUniversityId(UID);
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Mono<Optional<Course>> courseById(@PathVariable("id") int CID){
        return aggregateService.courseByID(CID);
    }

    @RequestMapping(value = "/course/all", method = RequestMethod.GET)
    public Flux<Course> allCourses(){
        return aggregateService.allCourses();
    }

    @RequestMapping(value = "/new-course", method = RequestMethod.POST)
    public String newCourse(@RequestBody Course course){
        return aggregateService.newCourse(course);
    }

    @RequestMapping(value = "/remove-course/{id}", method = RequestMethod.POST)
    public Mono<Optional<Course>> deleteCourseById(@PathVariable("id") int CID){
        return aggregateService.deleteCourseById(CID);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Mono<Optional<User>> userById(@PathVariable("id") int UID){
        return aggregateService.userByID(UID);
    }

    @RequestMapping(value = "/remove-user/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") int UID){
        return aggregateService.removeUserByID(UID);
    }

    @RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public String newUser(@RequestBody User user){
        return aggregateService.addUser(user);
    }

    @RequestMapping(value = "/user-login", method = RequestMethod.POST)
    public int authenticateLoginRequest(@RequestBody loginRequest credentials){
        return aggregateService.authenticateLoginRequest(credentials);
    }
}

