package view;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;

public class TelaLogin {
    private JPanel painelLogin;
    private JLabel facalogin;
    private JLabel usuario;
    private JTextField textField1; // campo para email
    private JLabel senha;
    private JPasswordField passwordField1; // campo para senha
    private JButton entrar;
    private JButton sairButton;
    private JLabel imagem;
    private JLabel imgpipoca;


    public TelaLogin() {
        entrar.addActionListener(e -> {
            String email = textField1.getText();
            String senha = new String(passwordField1.getPassword());

            UsuarioController controller = new UsuarioController();
            Usuario usuario = controller.autenticar(email, senha);

            if (usuario != null) {
                JOptionPane.showMessageDialog(painelLogin, "Bem-vinda, " + usuario.getNome() + "!");

                JFrame frame = new JFrame("Cinema - Tela Inicial");
                frame.setContentPane(new TelaHome().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                SwingUtilities.getWindowAncestor(painelLogin).dispose();

            } else {
                JOptionPane.showMessageDialog(painelLogin, "Email ou senha incorretos!");
            }
        });

        sairButton.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(painelLogin, "Deseja sair?");
            if (opcao == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    };

}

