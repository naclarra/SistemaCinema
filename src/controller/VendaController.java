package controller;

import DAO.SessaoDAO;
import DAO.VendaDAO;
import model.Sessao;
import model.Venda;

import java.util.List;

public class VendaController {
    private VendaDAO vendaDAO = new VendaDAO();
    private SessaoDAO sessaoDAO = new SessaoDAO();

    public boolean registrarVenda(Venda venda) {
        try {
            vendaDAO.registrarVenda(venda);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sessao> listarSessoesDisponiveis() {
        return sessaoDAO.listarSessoesDisponiveis(); // Método a implementar no SessaoDAO
    }

    public boolean realizarVenda(Sessao sessao, int quantidade) {
        if (sessao == null || quantidade <= 0 || sessao.getLugaresDisponiveis() < quantidade) {
            return false;
        }

        // Atualiza a quantidade de lugares disponíveis na sessão
        sessao.setLugaresDisponiveis(sessao.getLugaresDisponiveis() - quantidade);

        try {
            // Atualiza sessão no banco
            sessaoDAO.atualizar(sessao);

            // Cria e registra a venda
            Venda venda = new Venda();
            venda.setSessao(sessao);
            venda.setQuantidade(quantidade);
            // Aqui pode colocar o usuário logado (aqui só um exemplo, ajustar depois)
            venda.setUsuario(null);
            venda.setValorTotal(sessao.getFilme().getPreco() * quantidade); // Ajustar preço no model

            vendaDAO.registrarVenda(venda);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

