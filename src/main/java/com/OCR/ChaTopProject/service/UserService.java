package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.User;                       //la classe User du package model est nécessaire pour que Java reconnaisse la classe User dans ce fichier
import com.OCR.ChaTopProject.repository.UserRepository;        //  Le UserRepository est l'interface qui gère la communication avec la base de données pour les entités User.
import org.springframework.beans.factory.annotation.Autowired; // Autowired est utilisé pour l'injection automatique de dépendances.
import org.springframework.stereotype.Service;                 // Marque cette classe comme un bean de service dans le contexte Spring indiquant qu'elle contient de la logique métier.
import java.util.List;

@Service
public class UserService {
}


/*
*  la couche service est également un pont entre le controller et le repository.
* @Service c’est une spécialisation de @Component. Son rôle est donc le même, mais son nom a une valeur sémantique pour ceux qui lisent votre code
*
*
* */