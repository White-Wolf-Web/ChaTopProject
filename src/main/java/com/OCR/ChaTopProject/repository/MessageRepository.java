package com.OCR.ChaTopProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OCR.ChaTopProject.model.Message;
public interface MessageRepository extends JpaRepository<Message, Long> {
}
