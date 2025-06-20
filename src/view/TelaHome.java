package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaHome {
    public JPanel panel1;
    private JLabel imagem;
    private JButton btnSair;
    private JButton btnComprar;
    private JButton btnEntrar;
    private JPanel panelbotoes;

    public TelaHome() {
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, "Abrir tela de login");
            }
        });

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel1, "Abrir compra sem cadastro");
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolha = JOptionPane.showConfirmDialog(panel1, "Deseja sair?");
                if (escolha == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}

