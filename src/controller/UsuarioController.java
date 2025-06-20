package controller;

import DAO.LoginDAO;
import model.Usuario;

public class UsuarioController {
    private LoginDAO loginDAO;

    public UsuarioController() {
        this.loginDAO = new LoginDAO();
    }

    public Usuario autenticar(String email, String senha) {
        return loginDAO.validarLogin(email, senha);
    }
}
