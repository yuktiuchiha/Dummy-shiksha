package com.dummshiksha.FacadeService.mediators;

import com.dummshiksha.UniversityService.Utils.UniversityFeignUtil;
//import com.dummshiksha.UniversityService.models.Course;
import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.UniversityService.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


public class UniversityMediatorService {

    @Autowired
    private UniversityFeignUtil universityFeignUtil;

    public Mono<Optional<University>> universityByUniversityId(int UID){
        return Mono.fromCallable(()->universityFeignUtil.UniversityByID(UID));
    }

    public Flux<University> allUniversities(){
        return (Flux<University>) universityFeignUtil.AllUniversities();
    }

    public String newUniversity(University university){
        return universityFeignUtil.NewUniveresity(university);
    }

    public Mono<Optional<University>> deleteUniversityById(int UID){
        return Mono.fromCallable(()->universityFeignUtil.DeleteUniversityByID(UID));
    }

    public Flux<Course> coursesByUniversityId(int UID){
        return (Flux<Course>) universityFeignUtil.CourseByUniversityId(UID);
    }
}
