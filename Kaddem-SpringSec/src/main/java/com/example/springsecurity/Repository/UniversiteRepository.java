package com.example.springsecurity.Repository;

import com.example.springsecurity.Entity.Universite;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UniversiteRepository  extends JpaRepository<Universite, Long> {
   Universite  findByEmail(String email);


}
