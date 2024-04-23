package fr.univrouen.cv24.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univrouen.cv24.model.CV24type;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CVRepositorie extends JpaRepository<CV24type, Long> {
    List<CV24type> findAll();
}