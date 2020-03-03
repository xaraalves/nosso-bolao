package bolaoSpring.service;

import bolaoSpring.controller.dto.CampeonatoDto;
import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.model.Campeonato;
import bolaoSpring.model.Time;
import bolaoSpring.repository.CampeonatoRepository;
import bolaoSpring.controller.form.CampeonatoForm;
import bolaoSpring.repository.TimeRepository;
import bolaoSpring.service.exception.ChampioshipAlreadyExistsException;
import bolaoSpring.service.exception.TeamDoesNotExistException;
import bolaoSpring.service.exception.WrongNumberOfTeamsInChampionshipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    CampeonatoRepository campeonatoRepository;
    @Autowired
    TimeRepository timeRepository;

    public Campeonato cadastrarCampeonato(CampeonatoForm campeonatoForm) {
        Campeonato campeonatoPesquisar = campeonatoRepository.findByNome(campeonatoForm.getNome());
        if(campeonatoPesquisar != null) {
            throw new ChampioshipAlreadyExistsException();
        }

        if(campeonatoForm.getQtdeTimes() != campeonatoForm.getTimes().size()) {
            throw new WrongNumberOfTeamsInChampionshipException();
        }

        List<Time> timesEncontrados = timeRepository.findByNomeIn(campeonatoForm.getNomesTimes());


        if(campeonatoForm.getTimes().size() != timesEncontrados.size())
            throw new TeamDoesNotExistException();

            return campeonatoRepository.save(new Campeonato(campeonatoForm.getNome(), campeonatoForm.getDataInicio(), campeonatoForm.getQtdeTimes(), timesEncontrados));

    }

}
