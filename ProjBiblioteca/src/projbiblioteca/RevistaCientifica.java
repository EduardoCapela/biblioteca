
package projbiblioteca;


class RevistaCientifica extends Revista {
    protected String areaPesquisa;

    public RevistaCientifica(String titulo, String autor, int anoPublicacao, String editora, String areaPesquisa) {
        super(titulo, autor, anoPublicacao, editora);
        this.areaPesquisa = areaPesquisa;
    }

    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public void setAreaPesquisa(String areaPesquisa) {
        this.areaPesquisa = areaPesquisa;
    }


    @Override
    public String toString() {
        return "Tipo: RevistaCientifica, Título: " + titulo + ", Autor: " + autor +
                ", Ano de Publicacao: " + anoPublicacao +
                ", Editora: " + editora +
                ", AreaPesquisa: " + areaPesquisa ;
    }
}