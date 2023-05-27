package projbiblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class ProjBiblioteca {   

    public static void main(String[] args) {
        
        
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.carregarBiblioteca("Biblioteca.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Remover Item");
            System.out.println("3. Alugar Item");
            System.out.println("4. Devolver Item");
            System.out.println("5. Ver Lista de Itens");
            System.out.println("6. Ver Lista de Itens Alugados");
            System.out.println("7. Sair / Salvar Biblioteca");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("=== Adicionar Item ===");
                    System.out.println("Tipo de Item: ");
                    System.out.println("1. Livro");
                    System.out.println("2. Revista");
                    System.out.println("3. Revista Científica");
                    System.out.print("Opção: ");
                    int tipoItem = scanner.nextInt();

                    System.out.print("Título: ");
                    String titulo = scanner.next();
                    System.out.print("Autor: ");
                    String autor = scanner.next();
                    System.out.print("Ano de Publicação: ");
                    int anoPublicacao = scanner.nextInt();

                    ItemBiblioteca item;

                    switch (tipoItem) {
                        case 1:
                            System.out.print("Número de Páginas: ");
                            int numPaginas = scanner.nextInt();
                            item = new Livro(titulo, autor, anoPublicacao, numPaginas);
                            break;
                        case 2:
                            System.out.print("Editora: ");
                            String editora = scanner.next();
                            item = new Revista(titulo, autor, anoPublicacao, editora);
                            break;
                        case 3:
                            System.out.print("Editora: ");
                            String editoraRevistaCientifica = scanner.next();
                            System.out.print("Área de Pesquisa: ");
                            String areaPesquisa = scanner.next();
                            item = new RevistaCientifica(titulo, autor, anoPublicacao, editoraRevistaCientifica, areaPesquisa);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            continue;
                    }

                    biblioteca.adicionarItem(item);
                    System.out.println("Item adicionado com sucesso.");
                    break;
                case 2:
                    System.out.println("=== Remover Item ===");
                    System.out.print("Índice do Item: ");
                    int indiceRemover = scanner.nextInt();
                    biblioteca.removerItem(indiceRemover);
                    break;
                case 3:
                    System.out.println("=== Alugar Item ===");
                    System.out.print("Índice do Item: ");
                    int indiceAlugar = scanner.nextInt();
                    biblioteca.alugarItem(indiceAlugar);
                    break;
                case 4:
                    System.out.println("=== Devolver Item ===");
                    System.out.print("Índice do Item: ");
                    int indiceDevolver = scanner.nextInt();
                    biblioteca.devolverItem(indiceDevolver);
                    break;
                case 5:
                    System.out.println("=== Lista de Itens ===");
                    biblioteca.imprimirListaItens();
                    break;
                case 6:
                    System.out.println("=== Lista de Itens Alugados ===");
                    ArrayList<ItemBiblioteca> livrosAlugados = biblioteca.getListaLivrosAlugados();
                    for (ItemBiblioteca livro : livrosAlugados) {
                        livro.print();
                        System.out.println();
                    }
                    break;

                case 7:
                    System.out.println("Encerrando o programa e guardando...");
                    biblioteca.salvarBiblioteca("Biblioteca.txt");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println();
        }
    }
}