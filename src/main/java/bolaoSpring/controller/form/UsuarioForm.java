package bolaoSpring.controller.form;

import bolaoSpring.model.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {
    
    @NotNull(message = "Login não pode ser nulo")
    @NotEmpty(message = "Login não pode estar em branco")
    @Email(message = "Login precisa ser um email válido")
    private String login;

    @NotNull(message = "Senha não pode ser nula")
    @NotEmpty(message = "Senha não pode ser em branco")
    @Length(min = 6, message="Senha precisa ter no mínimo 6 caracteres")
    private String senha;

    public UsuarioForm() { }

    public UsuarioForm(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
