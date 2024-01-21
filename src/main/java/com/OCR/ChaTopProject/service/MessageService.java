package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.Message;                    // la classe Message du package model est nécessaire pour que Java reconnaisse la classe Message dans ce fichier
import com.OCR.ChaTopProject.repository.MessageRepository;     //  Le MessageRepository est l'interface qui gère la communication avec la base de données pour les entités Message.
import org.springframework.beans.factory.annotation.Autowired; // Autowired est utilisé pour l'injection automatique de dépendances.
import org.springframework.stereotype.Service;                 // Marque cette classe comme un bean de service dans le contexte Spring indiquant qu'elle contient de la logique métier.

import java.util.List;

@Service
public class MessageService {
}
