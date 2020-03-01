package bolaoSpring.controller;

import bolaoSpring.controller.form.CampeonatoForm;
import bolaoSpring.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;


    @PostMapping("/campeonato/cadastro")
    public ResponseEntity cadastrarCampeonato(@Valid @RequestBody CampeonatoForm campeonatoForm, UriComponentsBuilder uriComponentsBuilder) {
        String retorno = campeonatoService.cadastrarCampeonato(campeonatoForm);
        if(retorno.equals("OK")){
            URI uri = uriComponentsBuilder.path("/campeonato/{id}").buildAndExpand(campeonatoForm.getNome()).toUri();
            return ResponseEntity.created(uri).body(campeonatoService.buscarCampeonatoCadastrado(campeonatoForm.getNome()));
        }
        else if(retorno.equals("ERRO_NOME")) {
            return ResponseEntity.badRequest().body("Já existe um campeonato cadastrado com o nome " + campeonatoForm.getNome() + ".");
        }
        else if(retorno.equals("ERRO_QTDE_TIMES")) {
            return ResponseEntity.badRequest().body("A quantidade de times indicada deve ser a mesma do número de times informados.");
        }
        else if(retorno.equals("ERRO_TIME")) {
            return ResponseEntity.badRequest().body("Apenas times já cadastrados podem fazer parte de um campeonato.");
        }

        return ResponseEntity.badRequest().build();
    }

}
