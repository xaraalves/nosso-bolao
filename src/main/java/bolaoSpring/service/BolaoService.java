package bolaoSpring.service;

import bolaoSpring.controller.form.BolaoForm;
import bolaoSpring.model.Bolao;
import bolaoSpring.model.Campeonato;
import bolaoSpring.model.Usuario;
import bolaoSpring.repository.BolaoRepository;
import bolaoSpring.repository.CampeonatoRepository;
import bolaoSpring.repository.UsuarioRepository;
import bolaoSpring.service.exception.ChampionshipDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BolaoService {

    @Autowired
    private BolaoRepository bolaoRepository;

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Bolao cadastrarBolao(BolaoForm bolaoForm) {

        //======================================================
        Usuario dono = usuarioRepository.findByLogin("gabriel1@mail.com").get();
        //======================================================

        LocalDateTime agora = LocalDateTime.now();
        Campeonato campeonatoRelacionado = campeonatoRepository.findByNome(bolaoForm.getNomeCampeonato());
        if(campeonatoRelacionado == null) {
            throw new ChampionshipDoesNotExistException();
        }

        return bolaoRepository.save(new Bolao(dono, agora, campeonatoRelacionado, bolaoForm.getConvidados()));
    }
}
