package controller;

import DAO.LoginDAO;
import model.Usuario;

public class LoginController {
    public Usuario autenticar(String email, String senha) {
        return new LoginDAO().validarLogin(email, senha);
    }
}