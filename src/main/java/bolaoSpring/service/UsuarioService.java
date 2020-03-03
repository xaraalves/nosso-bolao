package bolaoSpring.service;

import bolaoSpring.controller.dto.UsuarioDto;
import bolaoSpring.model.Usuario;
import bolaoSpring.repository.UsuarioRepository;
import bolaoSpring.controller.form.UsuarioForm;
import bolaoSpring.service.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario   cadastrarUsuario(UsuarioForm usuarioForm) {
        //Pesquisa se o login/email já existe
        Optional<Usuario> usuarioPesquisa = usuarioRepository.findByLogin(usuarioForm.getLogin());
        if(usuarioPesquisa.isPresent())
            throw new UserAlreadyExistsException();
        String senhaHash = new BCryptPasswordEncoder().encode(usuarioForm.getSenha());
        return usuarioRepository.save(new Usuario(usuarioForm.getLogin(), senhaHash, LocalDateTime.now()));
    }

}
