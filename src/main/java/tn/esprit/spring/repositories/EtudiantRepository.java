package tn.esprit.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>
{
    Etudiant findByNomEAndPrenomE(String nomE, String prenomE);
}