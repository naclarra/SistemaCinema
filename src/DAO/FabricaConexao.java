package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    // Configurações do banco de dados (ajuste para seu MySQL!)
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USUARIO = "root";
    private static final String SENHA = "sua_senha";

    // Método que devolve a conexão pronta
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Registra o driver
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado!", e);
        }
    }
}
