package bolaoSpring.service;

import bolaoSpring.model.Usuario;
import bolaoSpring.repository.UsuarioRepository;
import bolaoSpring.request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String cadastrarUsuario(UsuarioRequest usuarioRequest) {
        //Pesquisa se o login/email já existe
        Usuario usuarioPesquisa = usuarioRepository.findByLogin(usuarioRequest.getLogin());
        if(usuarioPesquisa != null) {
            return "ERRO_LOGIN";
        }else {
            String senhaHash = passwordEncoder.encode(usuarioRequest.getSenha());
            usuarioRepository.save(new Usuario(usuarioRequest.getLogin(), senhaHash, new Date()));
        }
        return "OK";
    }

    public UsuarioRequest buscarUsuarioCadastrado(String login) {
        Usuario novoUsuario = usuarioRepository.findByLogin(login);
        return new UsuarioRequest(novoUsuario);
    }

}
