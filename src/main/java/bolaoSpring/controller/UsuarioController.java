package bolaoSpring.controller;

import javax.validation.Valid;

import bolaoSpring.request.UsuarioRequest;
import bolaoSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/usuario/cadastro")
	private ResponseEntity criarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder) {
		String retorno = usuarioService.cadastrarUsuario(usuarioRequest);
		URI uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuarioRequest.getLogin()).toUri();
		if(retorno.equals("OK")){
			//return ResponseEntity.ok().body("Usuário cadastrado com sucesso.");
			return ResponseEntity.created(uri).body(usuarioService.buscarUsuarioCadastrado(usuarioRequest.getLogin()));
		}
		else if(retorno.equals("ERRO_LOGIN")) {
			return ResponseEntity.badRequest().body("Já existe um usuário cadastrado com o email " + usuarioRequest.getLogin() + ".");
		}

		return ResponseEntity.badRequest().build();
	}

}
