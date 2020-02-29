package bolaoSpring.controller;

import bolaoSpring.request.TimeRequest;
import bolaoSpring.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TimeController {

    @Autowired
    TimeService timeService;



    @PostMapping("/time/cadastro")
    public ResponseEntity cadastrarTime(@Valid @RequestBody TimeRequest timeRequest) {
        String retorno = timeService.cadastrarTime(timeRequest);
        if(retorno.equals("OK")) {
            return ResponseEntity.ok().body("Time cadastrado com sucesso.");
        }
        else if(retorno.equals("ERRO_NOME")) {
            return ResponseEntity.badRequest().body("Já existe um time cadastrado com o nome " + timeRequest.getNome() + ".");
        }

        return ResponseEntity.badRequest().build();
    }

}
