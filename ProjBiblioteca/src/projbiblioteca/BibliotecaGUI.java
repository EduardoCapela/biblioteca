/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projbiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BibliotecaGUI extends JFrame {
    private Biblioteca biblioteca;
    private DefaultListModel<Livro> listModel;
    private JList<Livro> livroList;

    public BibliotecaGUI() {
        biblioteca = new Biblioteca();
        listModel = new DefaultListModel<>();
        livroList = new JList<>(listModel);

        // Configuração da janela principal
        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Componentes da janela
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton addButton = new JButton("Adicionar Livro");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarLivro();
            }
        });

        panel.add(addButton, BorderLayout.NORTH);
        panel.add(new JScrollPane(livroList), BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);

        // Exibição da janela
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void adicionarLivro() {
        // Lógica para adicionar um novo livro à biblioteca
        // Você pode usar caixas de diálogo para solicitar os dados do livro
        // e adicionar o livro à coleção da biblioteca

        // Após adicionar o livro, atualize a lista na interface
        //listModel.addElement(livro);
    }
    
}