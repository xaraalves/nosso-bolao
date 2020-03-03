package bolaoSpring.service;

import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.model.Time;
import bolaoSpring.repository.TimeRepository;
import bolaoSpring.controller.form.TimeForm;
import bolaoSpring.service.exception.TeamAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time cadastrarTime(TimeForm timeForm) {
        Time timePesquisa = timeRepository.findByNome(timeForm.getNome());
        if(timePesquisa != null) {
            throw new TeamAlreadyExistsException();
        }
        else {
             return timeRepository.save(new Time(timeForm.getNome(), timeForm.getDataFundacao()));
        }
    }

}
