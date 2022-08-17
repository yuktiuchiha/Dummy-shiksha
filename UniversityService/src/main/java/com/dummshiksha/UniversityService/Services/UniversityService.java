package com.dummshiksha.UniversityService.Services;


import com.dummshiksha.CourseService.models.Course;
import com.dummshiksha.UniversityService.Utils.FeignServiceUtil;
import com.dummshiksha.UniversityService.models.University;
import com.dummshiksha.UniversityService.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    public Optional<University> UniversityByID(int id){
        return universityRepository.findById(id);
    }

    public List<University> AllUniversities(){
        return universityRepository.findAll();
    }

    @Transactional
    public String NewUniversity(University university){
        universityRepository.save(university);
        return "new University added";
    }

    @Transactional
    public Optional<University> DeleteUniversityByID(int id){
        Optional<University> university = universityRepository.findById(id);
        universityRepository.deleteById(id);
        return university;
    }

    public List<Course> CoursesByUniversityId(int id){
        List<Course> response = feignServiceUtil.CoursesUByUniversityId(id);
        return response;
    }
}
