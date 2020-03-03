package bolaoSpring.controller;

import javax.validation.Valid;

import bolaoSpring.controller.dto.UsuarioDto;
import bolaoSpring.controller.form.UsuarioForm;
import bolaoSpring.service.UsuarioService;
import bolaoSpring.service.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDto(usuarioService.cadastrarUsuario(usuarioForm)));
		}
		catch (UserAlreadyExistsException userAlreadyExistsException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
