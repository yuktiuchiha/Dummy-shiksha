package com.dummshiksha.UniversityService.controller;


import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.UniversityService.Services.UniversityService;
import com.dummshiksha.UniversityService.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universityInfo")
@CrossOrigin(origins = "*")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public Optional<University> UniversityByID(@PathVariable("id") int id){
       Optional<University> university = universityService.UniversityByID(id);
       return university;
    }

    @RequestMapping(value = "/all-universities", method = RequestMethod.GET)
    public List<University> AllUniversities(){
        List<University> universities = universityService.AllUniversities();
        return universities;
    }

    @RequestMapping(value = "/new-university", method = RequestMethod.POST)
    public String NewUniversity(@RequestBody University university){
        return universityService.NewUniversity(university);
    }

    @RequestMapping(value = "/remove-university/{universityID}", method = RequestMethod.POST)
    public Optional<University> DeleteUniversityByID(@PathVariable("universityID") int id){
        Optional<University> deletedUniversity = universityService.DeleteUniversityByID(id);
        return deletedUniversity;
    }

    @RequestMapping(value = "/subjects-by-university/{universityId}", method = RequestMethod.GET)
    public List<Course> CoursesByUniversityId(@PathVariable("universityId") int id){
        return universityService.CoursesByUniversityId(id);
    }
}
