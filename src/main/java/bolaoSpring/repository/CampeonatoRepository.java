package bolaoSpring.repository;

import bolaoSpring.model.Campeonato;
import org.springframework.data.repository.CrudRepository;

public interface CampeonatoRepository extends CrudRepository<Campeonato, Long> {

    public Campeonato findByNome(String nome);
}
