package bolaoSpring.service;

import bolaoSpring.model.Campeonato;
import bolaoSpring.repository.CampeonatoRepository;
import bolaoSpring.request.CampeonatoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampeonatoService {

    @Autowired
    CampeonatoRepository campeonatoRepository;

    public String cadastrarCampeonato(CampeonatoRequest campeonatoRequest) {
        Campeonato campeonatoPesquisar = campeonatoRepository.findByNome(campeonatoRequest.getNome());
        if(campeonatoPesquisar != null) {
            return "ERRO_NOME";
        }
        else {
            campeonatoRepository.save(new Campeonato(campeonatoRequest.getNome(), campeonatoRequest.getDataInicio(), campeonatoRequest.getQtdeTimes()));
        }
        return "OK";
    }
}
