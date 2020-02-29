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

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/usuario/cadastro")
	@ResponseBody
	private ResponseEntity criarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		String retorno = usuarioService.cadastrarUsuario(usuarioRequest);
		if(retorno.equals("OK")){
			return ResponseEntity.ok().body("Usuário cadastrado com sucesso.");
		}
		else if(retorno.equals("ERRO_LOGIN")) {
			return ResponseEntity.badRequest().body("Já existe um usuário cadastrado com o email " + usuarioRequest.getLogin() + ".");
		}

		return ResponseEntity.badRequest().build();
	}

}
