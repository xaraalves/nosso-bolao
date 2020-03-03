package bolaoSpring.controller;

import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.controller.dto.UsuarioDto;
import bolaoSpring.controller.form.TimeForm;
import bolaoSpring.service.TimeService;
import bolaoSpring.service.exception.TeamAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity cadastrarTime(@Valid @RequestBody TimeForm timeForm) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new TimeDto(timeService.cadastrarTime(timeForm)));
        }
        catch (TeamAlreadyExistsException teamAlreadyExistsException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
