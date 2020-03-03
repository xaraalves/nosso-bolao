package bolaoSpring.controller.dto;

import bolaoSpring.model.Usuario;

import java.time.LocalDateTime;
import java.util.Optional;

public class UsuarioDto {

    private String login;
    private LocalDateTime dataRegistro;

    public UsuarioDto(Optional<Usuario> novoUsuario) {}

    public UsuarioDto(Usuario usuario) {
        this.login = usuario.getLogin();
        this.dataRegistro = usuario.getDataHora();
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
