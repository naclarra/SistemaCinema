package DAO;

import model.Usuario;
import java.sql.*;

public class LoginDAO {
    public Usuario validarLogin(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (Connection conn = FabricaConexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getString("tipo")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar login: " + e.getMessage());
        }
        return null;
    }
}