package bolaoSpring.controller;

import bolaoSpring.request.CampeonatoRequest;
import bolaoSpring.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;


    @PostMapping("/campeonato/cadastro")
    public ResponseEntity cadastrarCampeonato(@Valid @RequestBody CampeonatoRequest campeonatoRequest) {
        String retorno = campeonatoService.cadastrarCampeonato(campeonatoRequest);
        if(retorno.equals("OK")){
            return ResponseEntity.ok().body("Campeonato cadastrado com sucesso.");
        }
        else if(retorno.equals("ERRO_NOME")) {
            return ResponseEntity.badRequest().body("Já existe um campeonato cadastrado com o nome " + campeonatoRequest.getNome() + ".");
        }

        return ResponseEntity.badRequest().build();
    }

}
