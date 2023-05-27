package projbiblioteca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class Biblioteca {
    private ArrayList<ItemBiblioteca> listaItens;

    public Biblioteca() {
        listaItens = new ArrayList<>();
    }

    public void adicionarItem(ItemBiblioteca item) {
        listaItens.add(item);
    }

    public void removerItem(int indice) {
        if (indice >= 0 && indice < listaItens.size()) {
            listaItens.remove(indice);
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void alugarItem(int indice) {
        if (indice >= 0 && indice < listaItens.size()) {
            ItemBiblioteca item = listaItens.get(indice);
            if (!item.isAlugado()) {
                item.setAlugado(true);
                System.out.println("Item alugado com sucesso.");
            } else {
                System.out.println("O item já está alugado.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void devolverItem(int indice) {
        if (indice >= 0 && indice < listaItens.size()) {
            ItemBiblioteca item = listaItens.get(indice);
            if (item.isAlugado()) {
                item.setAlugado(false);
                System.out.println("Item devolvido com sucesso.");
            } else {
                System.out.println("O item já está disponível.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void imprimirListaItens() {
    for (int i = 0; i < listaItens.size(); i++) {
        ItemBiblioteca item = listaItens.get(i);
        System.out.print(i + ". ");
        item.print();
        System.out.print(", Disponível: " + !item.isAlugado());
        System.out.println();
    }
}
    
    public ArrayList<ItemBiblioteca> getListaItens() {
        return listaItens;
    }
    
    public ArrayList<ItemBiblioteca> getListaLivrosAlugados() {
        ArrayList<ItemBiblioteca> livrosAlugados = new ArrayList<>();
        for (ItemBiblioteca item : listaItens) {
            if (item.isAlugado()) {
                livrosAlugados.add(item);
            }
        }
        return livrosAlugados;
    }

    public void salvarBiblioteca(String nomeArquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(listaItens);
            objOut.close();
            fileOut.close();
            System.out.println("Biblioteca salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a biblioteca: " + e.getMessage());
        }
    }

    public void carregarBiblioteca(String nomeArquivo) {
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            listaItens = (ArrayList<ItemBiblioteca>) objIn.readObject();
            objIn.close();
            fileIn.close();
            System.out.println("Biblioteca carregada com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar a biblioteca: " + e.getMessage());
        }
    }
    
    
}