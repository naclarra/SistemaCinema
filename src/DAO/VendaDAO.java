package DAO;

import model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaDAO {

    public void registrarVenda(Venda venda) {
        String insertSql = "INSERT INTO vendas (id_sessao, id_usuario, quantidade, valor_total) VALUES (?, ?, ?, ?)";
        String updateSql = "UPDATE sessoes SET lugares_disponiveis = lugares_disponiveis - ? WHERE id = ?";

        try (Connection conn = dao.FabricaConexao.getConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psInsert = conn.prepareStatement(insertSql);
                 PreparedStatement psUpdate = conn.prepareStatement(updateSql)) {

                psInsert.setInt(1, venda.getSessao().getId());
                psInsert.setInt(2, venda.getUsuario().getId());
                psInsert.setInt(3, venda.getQuantidadeIngressos());
                psInsert.setDouble(4, venda.getValorTotal());
                psInsert.executeUpdate();

                psUpdate.setInt(1, venda.getQuantidadeIngressos());
                psUpdate.setInt(2, venda.getSessao().getId());
                psUpdate.executeUpdate();

                conn.commit();  // confirma a transação

            } catch (SQLException e) {
                conn.rollback();  // desfaz tudo se der erro
                throw e;
            } finally {
                conn.setAutoCommit(true); // volta ao modo normal
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar venda: " + e.getMessage(), e);
        }
    }
}
