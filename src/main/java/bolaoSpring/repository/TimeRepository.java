package bolaoSpring.repository;

import bolaoSpring.model.Time;
import org.springframework.data.repository.CrudRepository;

public interface TimeRepository extends CrudRepository<Time, Long> {

    public Time findByNome(String nome);
}
