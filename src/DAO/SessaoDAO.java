package DAO;

import model.Filme;
import model.Sala;
import model.Sessao;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SessaoDAO {
    public void cadastrar(Sessao sessao) {
        String sql = "INSERT INTO sessoes (horario, id_filme, id_sala, lugares_disponiveis) VALUES (?, ?, ?, ?)";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setTimestamp(1, Timestamp.valueOf(sessao.getHorario()));
            ps.setInt(2, sessao.getFilme().getId());
            ps.setInt(3, sessao.getSala().getId());
            ps.setInt(4, sessao.getLugaresDisponiveis());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    sessao.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar sessão: " + e.getMessage());
        }
    }

    public List<Sessao> listarPorFilme(int idFilme) {
        List<Sessao> sessoes = new ArrayList<>();
        String sql = "SELECT s.*, f.titulo as titulo_filme, sa.nome as nome_sala " +
                "FROM sessoes s " +
                "JOIN filmes f ON s.id_filme = f.id " +
                "JOIN salas sa ON s.id_sala = sa.id " +
                "WHERE s.id_filme = ?";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idFilme);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Sessao sessao = new Sessao(
                            rs.getInt("id"),
                            rs.getTimestamp("horario").toLocalDateTime(),
                            new Filme(rs.getInt("id_filme"), rs.getString("titulo_filme"), "", "", 0),
                            new Sala(rs.getInt("id_sala"), rs.getString("nome_sala"), 0),
                            rs.getInt("lugares_disponiveis")
                    );
                    sessoes.add(sessao);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar sessões: " + e.getMessage());
        }
        return sessoes;
    }

}