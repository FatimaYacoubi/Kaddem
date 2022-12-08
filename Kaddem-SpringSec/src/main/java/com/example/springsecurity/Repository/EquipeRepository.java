package com.example.springsecurity.Repository;



import com.example.springsecurity.Entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    @Query("SELECT e FROM Equipe e WHERE e.nomEquipe LIKE %?1%")
    public List<Equipe> search(String keyword);
    @Query("SELECT  e.niveau, COUNT(e) from Equipe e join DetailEquipe De on e=De.equipe group by e.niveau  ")
    List<String> stats();
}
