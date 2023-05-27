
package projbiblioteca;

class Revista extends ItemBiblioteca {
    protected String editora;

    public Revista(String titulo, String autor, int anoPublicacao, String editora) {
        super(titulo, autor, anoPublicacao);
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public void print() {
        System.out.print("Tipo: Revista" + ", titulo: " + titulo  +
                ", autor: " + autor + 
                ", anoPublicacao: " + anoPublicacao +
                ", editora: " + editora);
    }

    @Override
    public String toString() {
        return "Tipo: Revista, Título: " + titulo + ", Autor: " + autor +
                ", Ano de Publicacao: " + anoPublicacao +
                ", Editora: " + editora;
    }
}