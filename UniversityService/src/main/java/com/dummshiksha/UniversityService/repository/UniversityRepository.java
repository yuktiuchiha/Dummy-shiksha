package com.dummshiksha.UniversityService.repository;

import com.dummshiksha.UniversityService.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
