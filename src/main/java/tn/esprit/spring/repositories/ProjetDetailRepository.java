package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.ProjetDetail;

public interface ProjetDetailRepository extends JpaRepository<ProjetDetail,Long> {
}
