package com.acme.studenthome.domain.repository.UserAccountSystemRepository.StudentSystemRepository;

import com.acme.studenthome.domain.model.UserAccountSystem.StudentSystem.StudentOpinion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentOpinionRepository extends JpaRepository<StudentOpinion, Long> {
    Page<StudentOpinion> findByStudentIdAndLandLordId(Long studentId, Long landlordId, Pageable pageable);
    Page<StudentOpinion> findByStudentId(Long studentId, Pageable pageable);
    Page<StudentOpinion> findByLandLordId(Long landlordId, Pageable pageable);
    Optional<StudentOpinion> findByIdAndStudentIdAndLandLordId(Long id, Long studentId, Long landlordId);
}
