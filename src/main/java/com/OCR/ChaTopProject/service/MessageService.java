package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.Message;                    // la classe Message du package model est nécessaire pour que Java reconnaisse la classe Message dans ce fichier
import com.OCR.ChaTopProject.repository.MessageRepository;     //  Le MessageRepository est l'interface qui gère la communication avec la base de données pour les entités Message.
import org.springframework.beans.factory.annotation.Autowired; // Autowired est utilisé pour l'injection automatique de dépendances.
import org.springframework.stereotype.Service;                 // Marque cette classe comme un bean de service dans le contexte Spring indiquant qu'elle contient de la logique métier.
import java.util.List;

@Service                                                       // @Service est là pour dire à Spring qu'il s'agit d'un composant de service.
public class MessageService {
    private final MessageRepository messageRepository;         // Injection du repository pour interagir avec la base de données.

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;            // Le constructeur assigne le MessageRepository injecté à la variable locale.
    }

    public Message saveMessage(Message message) {              // Méthode pour sauvegarder un message. Avec messageRepository.save() pour enregistrer l'objet Message dans la base de données.
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {                    // Méthode pour récupérer tous les messages. Avec  messageRepository.findAll() pour obtenir une liste de tous les messages.
        return messageRepository.findAll();                    // La méthode findAll() est une méthode fournie par JpaRepository,elle est utilisée pour récupérer toutes les entrées de la table correspondante à l'entité Message dans la base de données.
    }
}
