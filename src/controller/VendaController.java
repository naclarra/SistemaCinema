package controller;

import DAO.VendaDAO;
import model.Venda;

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
}