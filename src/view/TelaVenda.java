package view;

import controller.VendaController;
import model.Sessao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TelaVenda extends JFrame {
    public JPanel panel1;
    private JPanel paineltopo;
    private JPanel painelmeio;
    private JPanel painelbaixo;
    private JLabel txtvenda;
    private JLabel txtsessao;
    private JLabel txtquantidade;
    private JComboBox<Sessao> comboBox1;
    private JTextField txtfieldqntd;
    private JButton btncomprar;
    private JButton btncancelar;

    private VendaController controller;

    public TelaVenda() {
        setTitle("Venda de Ingressos - Cinema");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1); // Usa o JPanel que você criou
        setSize(500, 300);
        setLocationRelativeTo(null);

        controller = new VendaController();

        configurarEstilo();
        configurarEventos();
        carregarSessoes();
    }

    private void configurarEstilo() {

        txtvenda.setFont(new Font("Arial", Font.BOLD, 18));
        txtvenda.setHorizontalAlignment(SwingConstants.CENTER);


        btncomprar.setBackground(new Color(46, 125, 50));
        btncomprar.setForeground(Color.WHITE);
        btncancelar.setBackground(new Color(198, 40, 40));
        btncancelar.setForeground(Color.WHITE);


        txtfieldqntd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
    }

    private void configurarEventos() {
        btncomprar.addActionListener(this::realizarVenda);
        btncancelar.addActionListener(e -> dispose());
    }

    private void carregarSessoes() {
        comboBox1.removeAllItems();

        comboBox1.addItem(new Sessao(0, LocalDateTime.now(), null, null, 0) {
            @Override
            public String toString() {
                return " Selecione uma sessão ";
            }
        });

        List<Sessao> sessoes = controller.listarSessoesDisponiveis();
        for (Sessao sessao : sessoes) {
            comboBox1.addItem(sessao);
        }
    }

    private void realizarVenda(ActionEvent evt) {
        if (!validarCampos()) return;

        try {
            Sessao sessao = (Sessao) comboBox1.getSelectedItem();
            int quantidade = Integer.parseInt(txtfieldqntd.getText());

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "Quantidade deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (controller.realizarVenda(sessao, quantidade)) {
                JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao realizar venda.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCampos() {
        if (comboBox1.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma sessão válida!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (txtfieldqntd.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a quantidade!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private void limparCampos() {
        txtfieldqntd.setText("");
        comboBox1.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaVenda tela = new TelaVenda();
            tela.setVisible(true);
        });
    }
}