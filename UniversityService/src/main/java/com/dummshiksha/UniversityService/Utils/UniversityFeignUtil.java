package com.dummshiksha.UniversityService.Utils;

import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.UniversityService.models.University;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "UniversityService", url = "${university.service.url}")
public interface UniversityFeignUtil {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<University> UniversityByID(@PathVariable("id") int id);

    @RequestMapping(value = "/all-universities", method = RequestMethod.GET)
    List<University> AllUniversities();

    @RequestMapping(value = "/new-university", method = RequestMethod.POST)
    String NewUniveresity(@RequestBody University university);

    @RequestMapping(value = "/remove-university/{universityID}", method = RequestMethod.POST)
    Optional<University> DeleteUniversityByID(@PathVariable("universityID") int id);

    @RequestMapping(value = "/subjects-by-university/{universityId}", method = RequestMethod.GET)
    List<Course> CourseByUniversityId(@PathVariable("universityId") int id);

}
