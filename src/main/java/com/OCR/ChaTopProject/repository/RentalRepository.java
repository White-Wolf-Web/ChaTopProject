package com.OCR.ChaTopProject.repository;

import com.OCR.ChaTopProject.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}


/*
 * JpaRepository<T, ID> prend deux paramètres génériques : T est le type de l'entité (importé du model) et ID est le type de la clé primaire de l'entité.
 * T est Rental et ID est Long (puisque l'ID de l'utilisateur est de type Long
 * Spring Data JPA implémente automatiquement les méthodes courantes de CRUD
 * */