package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroFilme extends JFrame {
    private JPanel panel1;
    private JPanel painel1;
    private JLabel lblTitulo;
    private JTextField txtTitulo;
    private JLabel lblDuracao;
    private JTextField txtDuracao;
    private JLabel lblGenero;
    private JTextField txtGenero;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private JLabel lblfilmes;

    public TelaCadastroFilme() {
        setTitle("Cadastro de Filme");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setContentPane(panel1);

        configurarEstilo();
        configurarEventos();
    }

    private void configurarEstilo() {
        btnSalvar.setBackground(new Color(76, 175, 80));
        btnSalvar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(244, 67, 54));
        btnCancelar.setForeground(Color.WHITE);

        txtDuracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        });
    }

    private void configurarEventos() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarFilme();
            }
        });
    }

    private void salvarFilme() {
        if (txtTitulo.getText().isEmpty() || txtDuracao.getText().isEmpty() || txtGenero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {

            String titulo = txtTitulo.getText();
            int duracao = Integer.parseInt(txtDuracao.getText());
            String genero = txtGenero.getText();

            // Aqui você deve chamar o Controller para salvar no banco de dados
            // Exemplo: new FilmeController().cadastrarFilme(titulo, duracao, genero);

            JOptionPane.showMessageDialog(this, "Filme cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duração deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtDuracao.setText("");
        txtGenero.setText("");
    }

    public static void main(String[] args) {
        // Teste da tela
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaCadastroFilme tela = new TelaCadastroFilme();
                tela.setVisible(true);
            }
        });
    }
}