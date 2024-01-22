package com.OCR.ChaTopProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.OCR.ChaTopProject.model.Message;
import com.OCR.ChaTopProject.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;               // Injection du service pour utiliser la logique métier.


    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;                  // Le constructeur => le MessageService injecté à la variable locale.
    }

    // Une méthode du controller pour créer tous les messages. Elle écoute les requêtes POST à "/api/messages".
    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) { // @RequestBody indique que le corps de la requête HTTP est mappé sur l'objet Message.
        Message savedMessage = messageService.saveMessage(message);              // J'appele la méthode saveMessage() de MessageService, l'objet Message retourné contiendra les informations
        return ResponseEntity.ok(savedMessage);                                  // Nous retourne une réponse avec le message sauvegardé et le statut 200
    }

    // Une méthode du controller pour récupérer tous les messages. Elle écoute les requêtes GET à "/api/messages".
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {          // Le List<Message> générique indique que l'objet ResponseEntity encapsulera une liste d'objets Message
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);                          // Retourne une réponse avec la liste des messages et le statut HTTP 200 OK.

    }
}
