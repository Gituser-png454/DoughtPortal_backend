package com.doubtportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doubtportal.entity.Doubt;

import java.util.List;

public interface DoubtRepository extends JpaRepository<Doubt, Long> {

    @Query("SELECT d FROM Doubt d WHERE LOWER(d.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(d.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(d.subject) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Doubt> searchByKeyword(@Param("keyword") String keyword);

    List<Doubt> findByUserId(Long userId);

    List<Doubt> findBySubjectIgnoreCase(String subject);
}