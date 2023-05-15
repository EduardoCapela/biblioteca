
package projbiblioteca;

public class RevistaCientifica extends Revista {
    private String areaPesquisa;

    public RevistaCientifica() {
        super();
    }

    public RevistaCientifica(String titulo, String autor, int anoPublicacao, String issn, String areaPesquisa) {
        super(titulo, autor, anoPublicacao, issn);
        this.areaPesquisa = areaPesquisa;
    }

    public RevistaCientifica(RevistaCientifica outro) {
        super(outro);
        this.areaPesquisa = outro.areaPesquisa;
    }

    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public void setAreaPesquisa(String areaPesquisa) {
        this.areaPesquisa = areaPesquisa;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Área de Pesquisa: " + areaPesquisa);
    }
}
