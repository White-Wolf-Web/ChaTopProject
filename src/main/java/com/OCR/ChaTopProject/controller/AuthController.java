package com.OCR.ChaTopProject.controller;

import com.OCR.ChaTopProject.model.User;
import com.OCR.ChaTopProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                                            // Cette annotation nous informe que cette classe est un contrôleur REST. Pour gérer les requêtes HTTP.
@RequestMapping("/auth")                                // Cette annotation nous informe que les URL de ce contrôleur commenceront par "/auth".
public class AuthController {

    private final AuthService authService;                 // Déclaration d'une variable privée finale pour le service d'authentification.

    @Autowired                                             // Cette annotation informe Spring d'injecter automatiquement l'instance de AuthService lors de la création de AuthController.
    public AuthController(AuthService authService) {
        this.authService = authService;                    // Affectation de l'instance de AuthService à la variable locale.
    }

    @PostMapping("/register")                            // Cette annotation m'informe que cette méthode gère les requêtes POST envoyées à "/auth/register".
    public ResponseEntity<User> registerUser(@RequestBody User newUser) { // Le @RequestBody indique que les détails de l'utilisateur seront envoyés dans le corps de la requête HTTP.
        User user = authService.register(newUser);         // Appel de la méthode register de authService pour enregistrer le nouvel utilisateur.
        return ResponseEntity.ok(user);                    // Si OK alors il renvoie une réponse 200 avec les données de l'utilisateur.
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginDetails) {
        String token = authService.login(loginDetails.getEmail(), loginDetails.getPassword()); // Appel de la méthode login pour vérifier les identifiants et obtenir un token.
        if (token != null) {                               // Si un token est reçu, l'authentification a réussi.
            return ResponseEntity.ok().body(token);        // Il renvoie le token avec une réponse HTTP 200.
        } else {
            return ResponseEntity.status(401).build();     // Il renvoie une réponse HTTP 401 Unauthorized.
        }
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@RequestParam String email) {               // @RequestParam indique que l'email de l'utilisateur sera un paramètre de la requête HTTP.
        User user = authService.findByEmail(email);                                        // On cherche l'utilisateur par son email.
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build(); // et renvoie une réponse HTTP 404 Not Found.
    }
}
