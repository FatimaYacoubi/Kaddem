package com.example.springsecurity.Repository;
import com.example.springsecurity.Entity.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
    @Query("SELECT p FROM Partenaire p WHERE p.nomPartenaire LIKE %?1%"

    )
    public List<Partenaire> search(String keyword);

    @Query("select  p.support, COUNT(u) from Universite u join Partenaire p on u=p.universites group by p.support  ")
    List<String> stats();
   Partenaire findByEmail(String email);

}
