package bolaoSpring.controller.dto;

import bolaoSpring.model.Usuario;

import java.time.LocalDateTime;

public class UsuarioDto {

    private String login;
    private String senha;
    private LocalDateTime dataRegistro;

    public UsuarioDto() {}

    public UsuarioDto(Usuario usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.dataRegistro = usuario.getDataHora();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
