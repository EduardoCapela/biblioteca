
package projbiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BibliotecaGUI extends JFrame {
    private Biblioteca biblioteca;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JButton addButton;
    private JButton removeButton;
    private JButton rentButton;
    private JButton returnButton;
    private JButton showItemsButton;
    private JButton showRentedItemsButton;
    private JButton saveButton;

    public BibliotecaGUI() {
        biblioteca = new Biblioteca();
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);

        addButton = new JButton("Adicionar Item");
        removeButton = new JButton("Remover Item");
        rentButton = new JButton("Alugar Item");
        returnButton = new JButton("Devolver Item");
        showItemsButton = new JButton("Ver Lista de Itens");
        showRentedItemsButton = new JButton("Ver Lista de Itens Alugados");
        saveButton = new JButton("Sair / Salvar Biblioteca");
        
        

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerItem();
            }
        });

        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alugarItem();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverItem();
            }
        });

        showItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirListaItens();
            }
        });

        showRentedItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirListaItensAlugados();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarBiblioteca();
                System.exit(0); // Fecha o programa ao salvar a biblioteca
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(rentButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(showItemsButton);
        buttonPanel.add(showRentedItemsButton);
        buttonPanel.add(saveButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        setTitle("Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        add(mainPanel);
        
        JLabel titleLabel = new JLabel("Artigos da Biblioteca");
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Centralizar o texto do rótulo
        Font font = titleLabel.getFont();
        Font biggerFont = font.deriveFont(font.getSize() + 5f); // Aumentar o tamanho da fonte em 5 pontos
        titleLabel.setFont(biggerFont);
        mainPanel.add(titleLabel, BorderLayout.NORTH); // Adicionar o rótulo acima da lista
        mainPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        carregarBiblioteca(); // Carrega a biblioteca ao iniciar o programa
    }

    private void adicionarItem() {
    String[] tipos = {"Livro", "Revista", "Revista Científica"};
    int tipoItem = JOptionPane.showOptionDialog(null, "Tipo de Item:", "Selecionar Tipo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);

    if (tipoItem == -1) {
        // Nenhum tipo de item selecionado
        return;
    }

    String titulo = JOptionPane.showInputDialog("Título:");
    String autor = JOptionPane.showInputDialog("Autor:");
    int anoPublicacao = Integer.parseInt(JOptionPane.showInputDialog("Ano Publicação:"));

    switch (tipoItem) {
        case 0:
            adicionarLivro(titulo, autor, anoPublicacao);
            break;
        case 1:
            adicionarRevista(titulo, autor, anoPublicacao);
            break;
        case 2:
            adicionarRevistaCientifica(titulo, autor, anoPublicacao);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opção inválida.");
    }
}

private void adicionarLivro(String titulo, String autor,int anoPublicacao) {
    int numPaginas = Integer.parseInt(JOptionPane.showInputDialog("Número de Páginas:"));
    ItemBiblioteca livro = new Livro(titulo, autor, anoPublicacao, numPaginas);
    biblioteca.adicionarItem(livro);
    listModel.addElement(livro.toString());
    exibirListaItens();
}

private void adicionarRevista(String titulo, String autor, int anoPublicacao) {
    String editora = JOptionPane.showInputDialog("editora:");
    ItemBiblioteca revista = new Revista(titulo, autor, anoPublicacao, editora);
    biblioteca.adicionarItem(revista);
    listModel.addElement(revista.toString());
    exibirListaItens();
}

private void adicionarRevistaCientifica(String titulo, String autor, int anoPublicacao) {
    String editora = JOptionPane.showInputDialog("Editora:");
    String areaPesquisa = JOptionPane.showInputDialog("Área de Pesquisa:");
    ItemBiblioteca revistaCientifica = new RevistaCientifica(titulo, autor, anoPublicacao, editora, areaPesquisa);
    biblioteca.adicionarItem(revistaCientifica);
    listModel.addElement(revistaCientifica.toString());
    exibirListaItens();
}
    private void removerItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex >= 0) {
            biblioteca.removerItem(selectedIndex);
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado.");
        }
        exibirListaItens();
    }

    private void alugarItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex >= 0) {
            biblioteca.alugarItem(selectedIndex);
            String itemString = itemList.getSelectedValue();
            itemString += " (Alugado)";
            listModel.set(selectedIndex, itemString);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado.");
        }
        exibirListaItens();
    }

    private void devolverItem() {
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex >= 0) {
            biblioteca.devolverItem(selectedIndex);
            String itemString = itemList.getSelectedValue();
            itemString = itemString.replace(" (Alugado)", "");
            listModel.set(selectedIndex, itemString);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado.");
        }
        exibirListaItens();
    }

    private void exibirListaItens() {
        int index = 1;
        listModel.clear();
        String x = "X";
        for (ItemBiblioteca item : biblioteca.getListaItens()) {
            if(item.isAlugado() == true) {
                x = "(Alugado)";
            } else {
                 x = "(Livre)";
            }
            String itemString = index + ". " + item.toString() + " " +x;
            listModel.addElement(itemString) ;
            index++;
        }
    }

    private void exibirListaItensAlugados() {
        int index = 1;
        listModel.clear();
        for (ItemBiblioteca item : biblioteca.getListaLivrosAlugados()) {
            String itemString = index + ". " + item.toString();
            listModel.addElement(itemString);
            index++;
        }
    }

    private void salvarBiblioteca() {
        biblioteca.salvarBiblioteca("Biblioteca.txt");
    }

    private void carregarBiblioteca() {
        biblioteca.carregarBiblioteca("Biblioteca.txt");
        exibirListaItens();
    }

}