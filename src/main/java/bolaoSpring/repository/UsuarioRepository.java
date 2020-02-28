package bolaoSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bolaoSpring.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByLogin(String login);
}
