package com.tiketi.service; // Définit le package du service

import com.tiketi.model.User; // Importe la classe User du modèle
import com.tiketi.repository.UserRepository; // Importe le repository UserRepository
import lombok.AllArgsConstructor; // Importe l'annotation pour générer un constructeur avec tous les paramètres
import org.springframework.beans.factory.annotation.Autowired; // Importe l'annotation pour l'injection de dépendances
import org.springframework.stereotype.Service; // Importe l'annotation pour définir cette classe comme un service Spring
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List; // Importe la classe List pour les collections
import java.util.Optional; // Importe la classe Optional pour encapsuler les résultats des requêtes

@AllArgsConstructor // Génère un constructeur avec tous les paramètres grâce à Lombok
@Service // Indique que cette classe est un service Spring
public class ServiceUser {

    @Autowired // Injection automatique du repository UserRepository
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Méthode pour récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Méthode pour créer un nouvel utilisateur
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Méthode pour mettre à jour un utilisateur existant
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(); // Trouve l'utilisateur par son ID ou lance une exception
        user.setName(userDetails.getName()); // Met à jour le nom de l'utilisateur
        user.setMail(userDetails.getMail()); // Met à jour l'email de l'utilisateur
        user.setPassword(userDetails.getPassword()); // Met à jour le mot de passe de l'utilisateur
        user.setRole(userDetails.getRole()); // Met à jour le rôle de l'utilisateur
        return userRepository.save(user); // Sauvegarde les modifications et retourne l'utilisateur mis à jour
    }

    // Méthode pour supprimer un utilisateur par son ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
