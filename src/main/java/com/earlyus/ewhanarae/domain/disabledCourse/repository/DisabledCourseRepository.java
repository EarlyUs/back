package com.earlyus.ewhanarae.domain.disabledCourse.repository;

import com.earlyus.ewhanarae.domain.disabledCourse.domain.DisabledCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface DisabledCourseRepository extends JpaRepository<DisabledCourse, Long> {
    Optional<DisabledCourse> findByMajor(String major);
}

