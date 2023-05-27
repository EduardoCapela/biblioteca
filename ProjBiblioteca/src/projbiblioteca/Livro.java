
package projbiblioteca;

class Livro extends ItemBiblioteca {
    private int numPaginas;

    public Livro(String titulo, String autor, int anoPublicacao, int numPaginas) {
        super(titulo, autor, anoPublicacao);
        this.numPaginas = numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public void print() {
        System.out.print("Tipo: Livro, " + "Título: " + titulo +", Autor: " + autor + ", Ano de Publicação: " + anoPublicacao+ ", Número de Páginas: " + numPaginas);
    }

    @Override
    public String toString() {
        return "Tipo: Livro, " + "Título: " + titulo +", Autor: " + autor + ", Ano de Publicação: " + anoPublicacao+ ", Número de Páginas: " + numPaginas;
    }
}