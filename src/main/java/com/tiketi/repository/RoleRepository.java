package com.tiketi.repository;

import com.tiketi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Interface pour interagir avec la base de données pour les rôles
}
