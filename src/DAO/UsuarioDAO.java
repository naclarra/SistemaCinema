package DAO;

import model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha()); // Ideal: usar BCrypt
            ps.setString(4, usuario.getTipo());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}