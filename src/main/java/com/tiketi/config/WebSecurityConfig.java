package com.tiketi.config; // Définir le package de la configuration de sécurité

import com.tiketi.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired; // Importer l'annotation pour l'injection de dépendances
import org.springframework.context.annotation.Bean; // Importer l'annotation pour définir un bean Spring
import org.springframework.context.annotation.Configuration; // Importer l'annotation pour indiquer que cette classe est une configuration Spring
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Importer la classe pour construire la sécurité web
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // Importer l'annotation pour activer la sécurité web
import org.springframework.security.config.http.SessionCreationPolicy; // Importer la politique de création de session
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importer l'encodeur de mot de passe BCrypt
import org.springframework.security.crypto.password.PasswordEncoder; // Importer l'interface de l'encodeur de mot de passe
import org.springframework.security.web.SecurityFilterChain; // Importer la chaîne de filtres de sécurité

@Configuration // Indiquer que cette classe est une classe de configuration Spring
@EnableWebSecurity // Activer la sécurité Web dans l'application Spring
@AllArgsConstructor
public class WebSecurityConfig{

    @Autowired // Injection de dépendance automatique de CustomUserDetailsService
    private CustomUserDetailsService customUserDetailsService; // Injecter CustomUserDetailsService

    @Bean // Définir un bean Spring pour la chaîne de filtres de sécurité
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                .csrf().disable() // Désactiver la protection CSRF (Cross-Site Request Forgery)
                .authorizeRequests() // Commencer à définir les règles d'autorisation des requêtes
                .requestMatchers("/api/administrateurs/**").hasRole("ADMINISTRATEUR") // Autoriser uniquement les utilisateurs ayant le rôle ADMINISTRATEUR à accéder aux endpoints "/api/administrateurs/**"
                .requestMatchers("/api/formateurs/**").hasAnyRole("ADMINISTRATEUR", "FORMATEUR") // Autoriser les utilisateurs ayant les rôles ADMINISTRATEUR ou FORMATEUR à accéder aux endpoints "/api/formateurs/**"
                .requestMatchers("/api/apprenants/**").hasAnyRole("ADMINISTRATEUR", "APPRENANT") // Autoriser les utilisateurs ayant les rôles ADMINISTRATEUR ou APPRENANT à accéder aux endpoints "/api/apprenants/**"
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Autoriser l'accès public aux endpoints "/swagger-ui/**" et "/v3/api-docs/**"
                .requestMatchers("/api/tickets/**").authenticated() // Exiger l'authentification pour accéder aux endpoints "/api/tickets/**"
                .requestMatchers("/api/roles/**").hasRole("ADMINISTRATEUR") // Exiger l'authentification et le rôle ADMINISTRATEUR pour accéder aux endpoints "/api/roles/**"
                .requestMatchers("/api/categories/**").hasRole("ADMINISTRATEUR") // Exiger l'authentification et le rôle ADMINISTRATEUR pour accéder aux endpoints "/api/categories/**"
                .requestMatchers("/api/users/**").hasRole("ADMINISTRATEUR") // Exiger l'authentification et le rôle ADMINISTRATEUR pour accéder aux endpoints "/api/users/**"
                .requestMatchers("/api/reponses/**").authenticated() // Exiger l'authentification et le rôle ADMINISTRATEUR pour accéder aux endpoints "/api/reponses/**"
                .requestMatchers("/api/notifications/**").authenticated() // Exiger l'authentification pour accéder aux endpoints "/api/notifications/**"
                .requestMatchers("/api/base-connaissances/**").authenticated() // Exiger l'authentification pour accéder aux endpoints "/api/base-connaissances/**"
                .anyRequest().permitAll() // Autoriser l'accès public à toutes les autres requêtes
                .and() // Séparateur pour ajouter une nouvelle configuration
                .formLogin().permitAll() // Permettre l'accès public à la page de login
                .and() // Séparateur pour ajouter une nouvelle configuration
                .logout().permitAll() // Permettre l'accès public à la page de logout
                .and() // Séparateur pour ajouter une nouvelle configuration
                .httpBasic() // Activer l'authentification HTTP Basic
                .and() // Séparateur pour ajouter une nouvelle configuration
                .sessionManagement() // Commencer la gestion des sessions
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Configurer les sessions comme étant sans état (stateless)
        return http.build(); // Construire la chaîne de filtres de sécurité
    }

    @Bean // Déclare que cette méthode retourne un bean Spring géré par le conteneur Spring
    public DaoAuthenticationProvider authenticationProvider() { // Définit un bean DaoAuthenticationProvider
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // Instancie un nouvel objet DaoAuthenticationProvider
        authProvider.setUserDetailsService(customUserDetailsService); // Configure le service de détails de l'utilisateur pour l'authentification
        authProvider.setPasswordEncoder(passwordEncoder()); // Configure l'encodeur de mot de passe pour l'authentification
        return authProvider; // Retourne l'objet authProvider en tant que bean géré par Spring
    } // Fin de la définition du bean authenticationProvider

    @Bean // Définir un bean Spring pour l'encodeur de mot de passe
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Retourner un encodeur de mot de passe BCrypt
    }
}
