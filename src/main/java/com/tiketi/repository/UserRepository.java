package com.tiketi.repository;

import com.tiketi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String email); // Définir la méthode de recherche par email
}
