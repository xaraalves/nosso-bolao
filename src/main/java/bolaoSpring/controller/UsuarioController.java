package bolaoSpring.controller;

import javax.validation.Valid;

import bolaoSpring.controller.form.UsuarioForm;
import bolaoSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/usuario/cadastro")
	private ResponseEntity criarUsuario(@Valid @RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriComponentsBuilder) {
		String retorno = usuarioService.cadastrarUsuario(usuarioForm);
		URI uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuarioForm.getLogin()).toUri();
		if(retorno.equals("OK")){
			return ResponseEntity.created(uri).body(usuarioService.buscarUsuarioCadastrado(usuarioForm.getLogin()));
		}
		else if(retorno.equals("ERRO_LOGIN")) {
			return ResponseEntity.badRequest().body("Já existe um usuário cadastrado com o email " + usuarioForm.getLogin() + ".");
		}

		return ResponseEntity.badRequest().build();
	}

}
