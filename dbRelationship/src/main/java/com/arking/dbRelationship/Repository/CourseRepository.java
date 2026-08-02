package com.arking.dbRelationship.Repository;

import com.arking.dbRelationship.Entity.student.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
