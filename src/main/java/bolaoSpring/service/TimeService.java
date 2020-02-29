package bolaoSpring.service;

import bolaoSpring.model.Time;
import bolaoSpring.repository.TimeRepository;
import bolaoSpring.request.TimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public String cadastrarTime(TimeRequest timeRequest) {
        Time timePesquisa = timeRepository.findByNome(timeRequest.getNome());
        if(timePesquisa != null) {
            return "ERRO_NOME";
        }
        else {
            timeRepository.save(new Time(timeRequest.getNome(), timeRequest.getDataFundacao()));
        }
        return "OK";
    }
}
