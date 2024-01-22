package com.OCR.ChaTopProject.service;

import com.OCR.ChaTopProject.model.Rental;                      // la classe Rental du package model est nécessaire pour que Java reconnaisse la classe Rental dans ce fichier
import com.OCR.ChaTopProject.repository.RentalRepository;       //  Le RentalRepository est l'interface qui gère la communication avec la base de données pour les entités Rental.
import org.springframework.beans.factory.annotation.Autowired;  // Autowired est utilisé pour l'injection automatique de dépendances.
import org.springframework.stereotype.Service;                  // Marque cette classe comme un bean de service dans le contexte Spring indiquant qu'elle contient de la logique métier.
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> findRentalById(Long id) {
        return rentalRepository.findById(id);
    }

    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRental(Rental rental) {
        return rentalRepository.save(rental); // save fait office de mise à jour si l'id est présent
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}


/*
* @Service : Elle est utilisée pour indiquer que la classe contient une logique métier.
* Gardez une séparation claire entre la logique métier (dans les services) et l'accès aux données (dans les repositories).
*
* */