package com.OCR.ChaTopProject.util;

import com.OCR.ChaTopProject.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
// Pour gérer tout ce qui concerne les jetons JWT
public class JwtUtil {

    private static final String SECRET_KEY = "your_secret_key";  // On définit ici une clé secrète complexe qui sera utilisée pour signer les jetons JWT
    public String generateToken(User user) {                     // Création d'un nouveau jeton JWT pour un utilisateur avec ses infos
        long now = System.currentTimeMillis();                   // Cela récupère le temps courant en millisecondes. Pour définir quand le jeton est créé et quand il expire.
        return Jwts.builder()                                    // Pour la construction d'un jeton JWT.
                .setSubject(user.getEmail())                     // Définit le sujet du jeton, ici l'e-mail de l'utilisateur pour identifier à qui appartient le jeton.
                .setIssuedAt(new Date(now))                      // Définit la date et l'heure de création du jeton.
                .setExpiration(new Date(now + 3600000))          // On définit l'expiration après 1 heure
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)  // On signe le jeton avec l'algorithme spécifié et la clé secrète.
                .compact();                                      // Termine la construction du jeton et le compacte en une chaîne de caractères.
    }
}
