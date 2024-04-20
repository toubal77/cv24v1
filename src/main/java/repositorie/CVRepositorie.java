package repositorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.CV24type;

import java.util.Optional;

@Repository
public interface CVRepositorie extends CrudRepository<CV24type, Long> {
    Optional<CV24type> findById(long id);
}