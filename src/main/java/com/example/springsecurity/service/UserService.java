package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.Entity.Rolee;
import com.example.springsecurity.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EtudiantRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Etudiant saveUser(Etudiant user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Rolee.USER);
        user.setBanned(false);
        user.setVerified(false);
        return userRepository.save(user);
    }

    public Optional<Etudiant> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void makeAdmin(String email){
        userRepository.UpdateUserRole(email, Rolee.ADMIN);
    }
}
