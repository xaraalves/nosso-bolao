package bolaoSpring.controller;

import bolaoSpring.controller.dto.BolaoDto;
import bolaoSpring.controller.dto.UsuarioDto;
import bolaoSpring.controller.form.BolaoForm;
import bolaoSpring.controller.form.UsuarioForm;
import bolaoSpring.model.Bolao;
import bolaoSpring.service.BolaoService;
import bolaoSpring.service.UsuarioService;
import bolaoSpring.service.exception.ChampionshipDoesNotExistException;
import bolaoSpring.service.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class BolaoController {

    @Autowired
    private BolaoService bolaoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/bolao/cadastro")
    public ResponseEntity cadastrarBolao(@RequestBody @Valid BolaoForm bolaoForm) {
        try {
            //Inserindo um usuario conhecido caso haja a necessidade, uma vez que a feature de autenticação não foi implementada ainda
            this.cadastrarUsuario("gabriel1@mail.com", "123456");
            return ResponseEntity.status(HttpStatus.CREATED).body(new BolaoDto(bolaoService.cadastrarBolao(bolaoForm)));
        }
        catch (ChampionshipDoesNotExistException championshipDoesNotExistException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campeonato relacionado não está cadastrado.");
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private void cadastrarUsuario(String login, String senha) {
        try {
            usuarioService.cadastrarUsuario(new UsuarioForm(login, senha));
        }
        catch (UserAlreadyExistsException userAlreadyExistsException) {
            System.out.println("Usuário mockado já havia sido cadastrado: tudo ok");
        }
    }


}
