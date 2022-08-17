package com.dummshiksha.FacadeService.Service;

import com.dummshiksha.FacadeService.mediators.CourseMediatorService;
import com.dummshiksha.FacadeService.mediators.UniversityMediatorService;
import com.dummshiksha.FacadeService.mediators.UserMediatorService;
//import com.dummshiksha.UniversityService.models.Course;
import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.UniversityService.models.University;
import com.dummshiksha.UserService.models.User;
import loginDTO.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class AggregateService {

    @Autowired
    private CourseMediatorService courseMediatorService;

    @Autowired
    private UniversityMediatorService universityMediatorService;

    @Autowired
    private UserMediatorService userMediatorService;

    public Mono<Optional<University>> universityById(int UID){
        return universityMediatorService.universityByUniversityId(UID);
    }

    public Flux<University> allUniversity(){
        return universityMediatorService.allUniversities();
    }

    public String newUniversity(University university){
        return universityMediatorService.newUniversity(university);
    }

    public Mono<Optional<University>> deleteUniversityById(int UID){
        return universityMediatorService.deleteUniversityById(UID);
    }

    public Flux<Course> coursesByUniversityId(int UID){
        return universityMediatorService.coursesByUniversityId(UID);
    }


    public Mono<Optional<Course>> courseByID(int CID){
        return courseMediatorService.courseByID(CID);
    }

    public Flux<Course> allCourses(){
        return courseMediatorService.allCourses();
    }

    public String newCourse(Course course){
        return courseMediatorService.newCourse(course);
    }

    public Mono<Optional<Course>> deleteCourseById(int CID){
        return courseMediatorService.deleteCourseById(CID);
    }


    public Mono<Optional<User>> userByID(int UID){
        return userMediatorService.userById(UID);
    }

    public String removeUserByID(int UID){
        return userMediatorService.removeUserById(UID);
    }

    public String addUser(User user){
        return userMediatorService.addUser((user));
    }

    public int authenticateLoginRequest(loginRequest credentials){
        return userMediatorService.authenticateLoginRequest(credentials);
    }

}
