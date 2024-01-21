package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.Rental;                      // la classe Rental du package model est nécessaire pour que Java reconnaisse la classe Rental dans ce fichier
import com.OCR.ChaTopProject.repository.RentalRepository;       //  Le RentalRepository est l'interface qui gère la communication avec la base de données pour les entités Rental.
import org.springframework.beans.factory.annotation.Autowired;  // Autowired est utilisé pour l'injection automatique de dépendances.
import org.springframework.stereotype.Service;                  // Marque cette classe comme un bean de service dans le contexte Spring indiquant qu'elle contient de la logique métier.


@Service
public class RentalService {
}

/*
* @Service : Elle est utilisée pour indiquer que la classe contient une logique métier.
* Gardez une séparation claire entre la logique métier (dans les services) et l'accès aux données (dans les repositories).
*
* */