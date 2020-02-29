package bolaoSpring.controller;

import javax.validation.Valid;

import bolaoSpring.request.UsuarioRequest;
import bolaoSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/usuario/criar")
	@ResponseBody
	private ResponseEntity<String> criarUsuario(@Valid @RequestBody UsuarioRequest usuarioCriar, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getAllErrors().toString(), HttpStatus.NOT_FOUND);
		}else {
			return usuarioService.cadastrarUsuario(usuarioCriar);
		}
	}


}
