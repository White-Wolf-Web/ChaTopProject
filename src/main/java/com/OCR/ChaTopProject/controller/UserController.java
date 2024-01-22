package com.OCR.ChaTopProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.OCR.ChaTopProject.model.User;
import com.OCR.ChaTopProject.service.UserService;

@RestController                             // L'annotation @RestController indique que cette classe est utilisée pour traiter les requêtes web dans le modèle MVC.
@RequestMapping("/api")                  // L'annotation @RequestMapping spécifie le chemin de base pour toutes les routes définies dans ce contrôleur.
public class UserController {

    private final UserService userService;  // Une instance de UserService qui contiendra la logique métier et les appels au repository.

    @Autowired                                        // @Autowired indique à Spring d'injecter une instance de UserService ici lors de la création d'un UserController.
    public UserController(UserService userService) {  // Le 'userService' sera injecté automatiquement par Spring grâce à l'annotation @Autowired
        this.userService = userService;               // 'this.userService' fait référence 'userService' de la classe UserController.
    }

    // Une route pour obtenir les informations d'un utilisateur spécifique par son ID.
    @GetMapping("/user/{id}")                                       // @GetMapping est une annotation qui nous informe de l'appel pour les requêtes HTTP GET.
    public ResponseEntity<User> getUserById(@PathVariable Long id) {  // '@PathVariable Long id' récupère la valeur 'id' du chemin de l'URL et la convertit en un objet Long.
        return userService.findById(id)                               // 'findById' retourne un 'Optional<User>', c' est une enveloppe pouvant contenir un objet 'User' ou rien.
                .map(ResponseEntity::ok)                              // Si 'User' est trouvé, 'map' est appliqué pour créer une 'ResponseEntity' avec le statut 200
                .orElse(ResponseEntity.notFound().build());           // Si aucun 'User' n'est trouvé (Optional est vide), 'orElse' est appelé. Cela créra une 'ResponseEntity' avec le statut 404
    }
}
