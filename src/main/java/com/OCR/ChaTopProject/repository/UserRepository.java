package com.OCR.ChaTopProject.repository;

import com.OCR.ChaTopProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
