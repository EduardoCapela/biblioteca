
package projbiblioteca;

import java.io.*;
import java.util.Objects;

abstract class ItemBiblioteca implements IExemplar, Cloneable, Serializable  {
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected boolean alugado;
    

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public abstract void print();

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor +
                ", Ano de Publicacao: " + anoPublicacao;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemBiblioteca that = (ItemBiblioteca) o;
        return anoPublicacao == that.anoPublicacao &&
                titulo.equals(that.titulo) &&
                autor.equals(that.autor);
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, anoPublicacao);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public void emprestar() {
        if (!alugado) {
            alugado = true;
            System.out.println("Item alugado com sucesso.");
        } else {
            System.out.println("O item já está alugado.");
        }
    }

    @Override
    public void devolver() {
        if (alugado) {
            alugado = false;
            System.out.println("Item devolvido com sucesso.");
        } else {
            System.out.println("O item já está disponível.");
        }
    }
    
}