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

    public ResponseEntity<String> cadastrarUsuario(UsuarioRequest usuarioCriar) {
        //Pesquisa se o login/email já existe
        Usuario usuarioPesquisa = usuarioRepository.findByLogin(usuarioCriar.getLogin());
        if(usuarioPesquisa != null) {
            return new ResponseEntity<String>("Já existe um usuário com esse email " + usuarioCriar.getLogin() + " cadastrado!", HttpStatus.NOT_FOUND);
        }else {
            String senhaHash = passwordEncoder.encode(usuarioCriar.getSenha());
            usuarioRepository.save(new Usuario(usuarioCriar.getLogin(), senhaHash, new Date()));
        }
        return new ResponseEntity<String>("Usuário cadastrado com sucesso!", HttpStatus.OK);
    }

}
