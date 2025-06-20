package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Filme;
import DAO.FabricaConexao;

public class FilmeDAO {

    public void cadastrar(Filme filme) {
        String sql = "INSERT INTO filmes (titulo, sinopse, genero, duracao_em_minutos) VALUES (?, ?, ?, ?)";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getSinopse());
            ps.setString(3, filme.getGenero());
            ps.setInt(4, filme.getDuracaoEmMinutos());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    filme.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar filme: " + e.getMessage());
        }
    }

    public List<Filme> listarTodos() {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT id, titulo, sinopse, genero, duracao_em_minutos FROM filmes";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Filme filme = new Filme(
                        rs.getString("titulo"),
                        rs.getString("sinopse"),
                        rs.getString("genero"),
                        rs.getInt("duracao_em_minutos")
                );
                filme.setId(rs.getInt("id"));
                filmes.add(filme);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar filmes: " + e.getMessage());
        }
        return filmes;
    }

    public void atualizar(Filme filme) {
        String sql = "UPDATE filmes SET titulo = ?, sinopse = ?, genero = ?, duracao_em_minutos = ? WHERE id = ?";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getSinopse());
            ps.setString(3, filme.getGenero());
            ps.setInt(4, filme.getDuracaoEmMinutos());
            ps.setInt(5, filme.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar filme: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM filmes WHERE id = ?";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir filme: " + e.getMessage());
        }
    }
}