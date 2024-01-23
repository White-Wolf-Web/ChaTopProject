package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.User;
import com.OCR.ChaTopProject.repository.UserRepository;
import com.OCR.ChaTopProject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;   // userRepository est injecté pour interagir avec la base de données concernant les utilisateurs.
    private final PasswordEncoder passwordEncoder; // passwordEncoder est utilisé pour encoder les mots de passe avant de les stocker en base de données.
    private final JwtUtil jwtUtil;                 // jwtUtil est un utilitaire pour générer et valider des tokens JWT (JSON Web Tokens).

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // Permet d'enregistrer un nouvel utilisateur.
    public User register(User newUser) {
        if (userRepository.findByEmail(newUser.getEmail()) != null) {            // Vérifiez si l'utilisateur existe déjà
            throw new RuntimeException("User already exists");                   // Lancer une exception ou gérer le cas où l'utilisateur existe déjà
        }
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());  // Encode le mot de passe avant de l'enregistrer
        newUser.setPassword(encodedPassword);                                    // Définit le mot de passe encodé pour l'utilisateur.
        return userRepository.save(newUser);                                     // Sauvegarde l'utilisateur dans la base de données et le retourne.
    }

    // Gère le processus de connexion.
    public String login(String email, String password) {
        User user = findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) { // Vérifie si l'utilisateur existe et si le mot de passe correspond.
            return jwtUtil.generateToken(user);                                      // Il génére le token JWT en utilisant JwtUtil
        }
        throw new RuntimeException("Login failed");                                  // Lancer une exception ou gérer l'échec de la connexion
    }

    // Pour trouver un utilisateur via son email.
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);                                    // Utilise le UserRepository pour rechercher l'utilisateur.
    }

    // Vous pourriez avoir d'autres méthodes ici...
}
