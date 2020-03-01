package bolaoSpring.repository;

import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.model.Time;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeRepository extends CrudRepository<Time, Long> {

    Time findByNome(String nome);
    List<Time> findByNomeIn(List<String> nomes);

}
