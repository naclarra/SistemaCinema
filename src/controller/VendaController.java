package controller;

import DAO.VendaDAO;
import model.Sessao;
import model.Venda;

import java.util.List;

public class VendaController {
    private VendaDAO dao = new VendaDAO();

    public boolean registrarVenda(Venda venda) {
        try {
            dao.registrarVenda(venda);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Sessao> listarSessoesDisponiveis() {
        return null;
    }

    public boolean realizarVenda(Sessao sessao, int quantidade) {
        return false;
    }
}
