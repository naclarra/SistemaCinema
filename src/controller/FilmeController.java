package controller;

import java.util.List;
import model.Filme;
import DAO.FilmeDAO;

public class FilmeController {
    public FilmeDAO filmeDAO;

    public FilmeController() {
        this.filmeDAO = new FilmeDAO();
    }

    public boolean salvarFilme(String titulo, String sinopse, String genero, String duracaoStr) {
        if (titulo == null || titulo.trim().isEmpty() || genero == null || genero.trim().isEmpty()) {
            return false;
        }

        try {
            int duracao = Integer.parseInt(duracaoStr);
            Filme novoFilme = new Filme(titulo, sinopse, genero, duracao);
            filmeDAO.cadastrar(novoFilme);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Filme> listarTodosFilmes() {
        return filmeDAO.listarTodos();
    }

    public boolean atualizarFilme(Filme filme) {
        try {
            filmeDAO.atualizar(filme);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean excluirFilme(int id) {
        try {
            filmeDAO.excluir(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}