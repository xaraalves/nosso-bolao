package bolaoSpring.service;

import bolaoSpring.controller.dto.UsuarioDto;
import bolaoSpring.model.Usuario;
import bolaoSpring.repository.UsuarioRepository;
import bolaoSpring.controller.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String cadastrarUsuario(UsuarioForm usuarioForm) {
        //Pesquisa se o login/email já existe
        Usuario usuarioPesquisa = usuarioRepository.findByLogin(usuarioForm.getLogin());
        if(usuarioPesquisa != null) {
            return "ERRO_LOGIN";
        }else {
            String senhaHash = passwordEncoder.encode(usuarioForm.getSenha());
            usuarioRepository.save(new Usuario(usuarioForm.getLogin(), senhaHash, LocalDateTime.now()));
        }
        return "OK";
    }

    public UsuarioDto buscarUsuarioCadastrado(String login) {
        Usuario novoUsuario = usuarioRepository.findByLogin(login);
        return new UsuarioDto(novoUsuario);
    }

}
