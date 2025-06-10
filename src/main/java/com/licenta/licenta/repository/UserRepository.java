package com.licenta.licenta.repository;

import com.licenta.licenta.model.Role;
import com.licenta.licenta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByAssignedTeam(String team);
    List<User> findByRoleAndIsApproved(Role role, Boolean isApproved);
    List<User> findByRole(Role role);
}