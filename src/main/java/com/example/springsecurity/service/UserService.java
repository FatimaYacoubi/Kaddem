package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.Entity.Rolee;
import com.example.springsecurity.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private EtudiantRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Etudiant saveUser(Etudiant user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Rolee.USER);
        user.setBanned(false);
        user.setVerified(false);
        user.setCreatedate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<Etudiant> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void makeAdmin(String email){
        userRepository.UpdateUserRole(email, Rolee.ADMIN);
    }

    @Override
    @Transactional
    public void MakeUserRole(String email){
        userRepository.UpdateUserRoleUser(email, Rolee.USER);
    }

    @Override
    @Transactional
    public void BannedUser(String email , Boolean bann){
        userRepository.BannUser(email,bann);
    }

    @Override
    @Transactional
    public void VerifyUser(String email , Boolean verif){
        userRepository.VerifyUser(email,verif);
    }
}
