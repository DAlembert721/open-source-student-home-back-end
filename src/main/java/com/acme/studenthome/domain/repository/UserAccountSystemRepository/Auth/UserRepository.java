package com.acme.studenthome.domain.repository.UserAccountSystemRepository.Auth;

import com.acme.studenthome.domain.model.UserAccountSystem.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
