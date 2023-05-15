/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projbiblioteca;

import javax.swing.SwingUtilities;


public class ProjBiblioteca {


    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Criar e adicionar itens à biblioteca
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Editora A");
        Livro livro2 = new Livro("1984", "George Orwell", 1949, "Editora B");
        Revista revista1 = new Revista("National Geographic", "Editora C", 2022, "Vol. 100");
        RevistaCientifica revistaCientifica1 = new RevistaCientifica("Revista de Ciência", "Editora D", 2023, "Vol. 1", "Área de Pesquisa X");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(revista1);
        biblioteca.adicionarItem(revistaCientifica1);

        // Imprimir a coleção e verificar a disponibilidade
        biblioteca.imprimirColecao();

        // Realizar empréstimo e devolução de um item
        biblioteca.realizarEmprestimo(0);
        biblioteca.realizarDevolucao(1);

        System.out.println("-------------------------");
        // Imprimir a coleção após as alterações e verificar a disponibilidade
        biblioteca.imprimirColecao();
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaGUI();
            }
        });
    }
    
}
