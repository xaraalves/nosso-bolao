package bolaoSpring.controller;

import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.controller.form.TimeForm;
import bolaoSpring.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class TimeController {

    @Autowired
    TimeService timeService;



    @PostMapping("/time/cadastro")
    public ResponseEntity cadastrarTime(@Valid @RequestBody TimeForm timeForm, UriComponentsBuilder uriComponentsBuilder) {
        String retorno = timeService.cadastrarTime(timeForm);
        if(retorno.equals("OK")) {
            URI uri = uriComponentsBuilder.path("/time/{id}").buildAndExpand(timeForm.getNome()).toUri();
            return ResponseEntity.created(uri).body(timeService.buscarTimeCadastrado(timeForm.getNome()));
        }
        else if(retorno.equals("ERRO_NOME")) {
            return ResponseEntity.badRequest().body("Já existe um time cadastrado com o nome " + timeForm.getNome() + ".");
        }

        return ResponseEntity.badRequest().build();
    }

}
