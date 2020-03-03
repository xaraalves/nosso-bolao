package bolaoSpring.controller;

import bolaoSpring.controller.dto.CampeonatoDto;
import bolaoSpring.controller.form.CampeonatoForm;
import bolaoSpring.service.CampeonatoService;
import bolaoSpring.service.exception.ChampioshipAlreadyExistsException;
import bolaoSpring.service.exception.TeamDoesNotExistException;
import bolaoSpring.service.exception.WrongNumberOfTeamsInChampionshipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;


    @PostMapping("/campeonato/cadastro")
    public ResponseEntity cadastrarCampeonato(@Valid @RequestBody CampeonatoForm campeonatoForm, UriComponentsBuilder uriComponentsBuilder) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new CampeonatoDto(campeonatoService.cadastrarCampeonato(campeonatoForm)));
        }
        catch (ChampioshipAlreadyExistsException champioshipAlreadyExistsException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um campeonato com este nome.");
        }
        catch (WrongNumberOfTeamsInChampionshipException wrongNumberOfTeamsInChampionshipException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O número de times deve ser igual à quantidade de times informados.");
        }
        catch (TeamDoesNotExistException teamDoesNotExistException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todos os times devem ser cadastrados antes de serem incluídos em um campeonato.");
        }
    }

}
