package com.tiketi.service; // Définit le package du service

import com.tiketi.model.User; // Importe la classe User du modèle
import com.tiketi.repository.UserRepository; // Importe le repository UserRepository
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Importe l'autorité SimpleGrantedAuthority de Spring Security
import org.springframework.security.core.userdetails.UserDetails; // Importe l'interface UserDetails de Spring Security
import org.springframework.security.core.userdetails.UserDetailsService; // Importe l'interface UserDetailsService de Spring Security
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Importe l'exception UsernameNotFoundException de Spring Security
import org.springframework.stereotype.Service; // Importe l'annotation pour indiquer que cette classe est un service Spring

import java.util.Collections; // Importe Collections pour la gestion des rôles

@Service // Indique que cette classe est un service Spring
public class CustomUserDetailsService implements UserDetailsService { // Implémente l'interface UserDetailsService de Spring Security

    @Autowired // Injection de dépendance du repository UserRepository
    private UserRepository userRepository; // Déclaration du repository UserRepository

    @Override // Surcharge de la méthode de chargement d'utilisateur par nom d'utilisateur
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException { // Charge un utilisateur par son adresse mail
        User user = userRepository.findByMail(mail) // Recherche l'utilisateur par son adresse mail dans le repository
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé")); // Lance une exception si l'utilisateur n'est pas trouvé

        return new org.springframework.security.core.userdetails.User(user.getMail(), // Crée un objet UserDetails avec les informations de l'utilisateur
                user.getPassword(), // Récupère le mot de passe de l'utilisateur
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRole_name().name()))); // Définit le rôle de l'utilisateur
    }
}