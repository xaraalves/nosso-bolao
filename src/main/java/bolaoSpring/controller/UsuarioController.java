package bolaoSpring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bolaoSpring.model.Usuario;
import bolaoSpring.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping("/usuario/criar")
	@ResponseBody
	private ResponseEntity<String> criarUsuario(@Valid @RequestBody Usuario usuarioCriar, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getAllErrors().toString(), HttpStatus.NOT_FOUND);
		}else {
			//Pesquisa se o login/email já existe
			Usuario usuarioPesquisa = usuarioRepository.findByLogin(usuarioCriar.getLogin());
			if(usuarioPesquisa != null) {
				return new ResponseEntity<String>("Já existe um usuário com esse email " + usuarioCriar.getLogin() + " cadastrado!", HttpStatus.NOT_FOUND);
			}else {
				usuarioRepository.save(usuarioCriar);
			}
		}
		return new ResponseEntity<String>("Usuário cadastrado com sucesso!", HttpStatus.OK);
	}
}
