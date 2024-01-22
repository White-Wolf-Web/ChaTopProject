package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.User;                       // la classe User du package model est nécessaire pour que Java reconnaisse la classe User dans ce fichier
import com.OCR.ChaTopProject.repository.UserRepository;        // Le UserRepository est l'interface qui gère la communication avec la base de données pour les entités User.
import org.springframework.beans.factory.annotation.Autowired; // Autowired est utilisé pour l'injection automatique de dépendances.
import org.springframework.stereotype.Service;                 // Marque cette classe comme un bean de service dans le contexte Spring indiquant qu'elle contient de la logique métier.
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Pour enregistrer un nouvel User
    public User registerUser(User newUser) {
        return userRepository.save(newUser);
    }

    // Pour récuperer un user par Email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Pour récupérer un user par ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Récupérer tous les users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Pour mettre à jour un User actuel
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {  // Si le User existe avant de faire une mise à jour
            return userRepository.save(user);
        }
        return null;                                    // Mais si User n'existe pas
    }

    // Pour supprimer un user par ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


/*
 *  la couche service est également un pont entre le controller et le repository.
 * @Service c’est une spécialisation de @Component. Son rôle est donc le même, mais son nom a une valeur sémantique pour ceux qui lisent votre code
 *
 *
 * */