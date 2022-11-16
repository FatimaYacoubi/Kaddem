package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Etudiant;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUserService {
    Etudiant saveUser(Etudiant user);

    Optional<Etudiant> findByEmail(String email);

    @Transactional
    void makeAdmin(String email);

    @Transactional
    void MakeUserRole(String email);

    @Transactional
    void BannedUser(String email, Boolean bann);

    @Transactional
    void VerifyUser(String email, Boolean verif);
}
