package com.OCR.ChaTopProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OCR.ChaTopProject.model.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}

/*
 * JpaRepository<T, ID> prend deux paramètres génériques : T est le type de l'entité (importé du model) et ID est le type de la clé primaire de l'entité.
 * T est Message et ID est Long (puisque l'ID de l'utilisateur est de type Long
 * Spring Data JPA implémente automatiquement les méthodes courantes de CRUD
 * */