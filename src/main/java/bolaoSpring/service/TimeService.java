package bolaoSpring.service;

import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.model.Time;
import bolaoSpring.repository.TimeRepository;
import bolaoSpring.controller.form.TimeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public String cadastrarTime(TimeForm timeForm) {
        Time timePesquisa = timeRepository.findByNome(timeForm.getNome());
        if(timePesquisa != null) {
            return "ERRO_NOME";
        }
        else {
            timeRepository.save(new Time(timeForm.getNome(), timeForm.getDataFundacao()));
        }
        return "OK";
    }

    public TimeDto buscarTimeCadastrado(String nome) {
        Time time = timeRepository.findByNome(nome);
        return new TimeDto(time);
    }
}
