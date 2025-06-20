import model.Usuario;
import view.TelaHome;
import controller.UsuarioController;
import javax.swing.*;

public static void main(String[] args) {
    JFrame frame = new JFrame("Cinema - Tela Inicial");
    frame.setContentPane(new TelaHome().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);


    public class TesteUsuarioController {
        public static void main(String[] args) {
            UsuarioController controller = new UsuarioController();

            Usuario usuario = controller.autenticar("email@teste.com", "1234");

            if (usuario != null) {
                System.out.println("Login OK! Usuário: " + usuario.getNome());
            } else {
                System.out.println("Login falhou!");
            }
        }
    }
}



