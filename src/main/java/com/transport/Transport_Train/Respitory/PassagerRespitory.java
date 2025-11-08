package com.transport.Transport_Train.Respitory;

import com.transport.Transport_Train.entites.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagerRespitory extends JpaRepository<Passager, Long> {
    Passager findByEmail(String email);
    Passager findByVerificationToken(String token);
}
