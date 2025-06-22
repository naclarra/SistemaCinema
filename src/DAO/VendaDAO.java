package DAO;

import model.Venda;
import java.sql.*;

public class VendaDAO {
    public void registrarVenda(Venda venda) {
        String sql = "INSERT INTO vendas (id_sessao, id_usuario, quantidade, valor_total) VALUES (?, ?, ?, ?)";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, venda.getSessao().getId());
            ps.setInt(2, venda.getUsuario().getId());
            ps.setInt(3, venda.getQuantidadeIngressos());
            ps.setDouble(4, venda.getValorTotal());
            ps.executeUpdate();

            String updateSql = "UPDATE sessoes SET lugares_disponiveis = lugares_disponiveis - ? WHERE id = ?";
            try (PreparedStatement updatePs = conn.prepareStatement(updateSql)) {
                updatePs.setInt(1, venda.getQuantidadeIngressos());
                updatePs.setInt(2, venda.getSessao().getId());
                updatePs.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar venda: " + e.getMessage());
        }
    }
}