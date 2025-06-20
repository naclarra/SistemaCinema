package controller;

import DAO.SessaoDAO;
import model.Sessao;
import java.util.List;

public class SessaoController {
    private SessaoDAO dao = new SessaoDAO();

    public void criarSessao(Sessao sessao) {
        dao.cadastrar(sessao);
    }

    public List<Sessao> listarSessoesPorFilme(int idFilme) {
        return dao.listarPorFilme(idFilme);
    }
}