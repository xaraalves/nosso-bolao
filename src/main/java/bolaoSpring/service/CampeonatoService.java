package bolaoSpring.service;

import bolaoSpring.controller.dto.CampeonatoDto;
import bolaoSpring.controller.dto.TimeDto;
import bolaoSpring.model.Campeonato;
import bolaoSpring.model.Time;
import bolaoSpring.repository.CampeonatoRepository;
import bolaoSpring.controller.form.CampeonatoForm;
import bolaoSpring.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeonatoService {

    @Autowired
    CampeonatoRepository campeonatoRepository;
    @Autowired
    TimeRepository timeRepository;

    public String cadastrarCampeonato(CampeonatoForm campeonatoForm) {
        Campeonato campeonatoPesquisar = campeonatoRepository.findByNome(campeonatoForm.getNome());
        if(campeonatoPesquisar != null) {
            return "ERRO_NOME";
        }

        if(campeonatoForm.getQtdeTimes() != campeonatoForm.getTimes().size()) {
            return "ERRO_QTDE_TIMES";
        }

        List<Time> timesEncontrados = timeRepository.findByNomeIn(campeonatoForm.getNomesTimes());

        if(campeonatoForm.getTimes().size() == timesEncontrados.size())
            campeonatoRepository.save(new Campeonato(campeonatoForm.getNome(), campeonatoForm.getDataInicio(), campeonatoForm.getQtdeTimes(), timesEncontrados));
        else return "ERRO_TIME";

        return "OK";
    }

    public CampeonatoDto buscarCampeonatoCadastrado(String nome) {
        Campeonato campeonato = campeonatoRepository.findByNome(nome);
        if(campeonato != null)
            return new CampeonatoDto(campeonato);

        return null;
    }
}
