package com.dummshiksha.CourseService.repository;

import com.dummshiksha.CourseService.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {


    @Modifying
    @Query(value = "Insert into courses (university_id, name, base_course, fees) values(?1, ?2, ?3, ?4);", nativeQuery = true)
    public void saveCourse(Integer universityId, String name, String baseCourse, BigDecimal fees);
//    public void saveCourse(Course course);        (?1, ?2, ?3, ?4)

    @Query(value = "SELECT * FROM courses WHERE university_id=(?1)", nativeQuery = true)
    public List<Course> CoursesByUniversityId(int UID);

    @Query(value = "UPDATE courses SET fees = (?1) WHERE course_id = (?2)", nativeQuery = true)
    public Optional<Course> UpdateCourseFeesByCourseId(BigDecimal fees, int CID);
}
