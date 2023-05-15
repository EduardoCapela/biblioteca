
package projbiblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> colecaoItens;

    public Biblioteca() {
        colecaoItens = new ArrayList<>();
    }

    public void adicionarItem(ItemBiblioteca item) {
        colecaoItens.add(item);
    }

    public void imprimirColecao() {
        for (ItemBiblioteca item : colecaoItens) {
            item.print();
            System.out.println("Disponível: " + item.verificarDisponibilidade());
            System.out.println();
        }
    }

    public void realizarEmprestimo(int indice) {
        if (indice >= 0 && indice < colecaoItens.size()) {
            ItemBiblioteca item = colecaoItens.get(indice);
            item.emprestar();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void realizarDevolucao(int indice) {
        if (indice >= 0 && indice < colecaoItens.size()) {
            ItemBiblioteca item = colecaoItens.get(indice);
            item.devolver();
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
