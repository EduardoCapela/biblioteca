
package projbiblioteca;


public abstract class ItemBiblioteca implements IExamplar {
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    // Outros atributos protegidos

    private static int totalItensBiblioteca = 0;

    // Construtores
    public ItemBiblioteca() {
        totalItensBiblioteca++;
    }

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        totalItensBiblioteca++;
    }

    public ItemBiblioteca(ItemBiblioteca outro) {
        this.titulo = outro.titulo;
        this.autor = outro.autor;
        this.anoPublicacao = outro.anoPublicacao;
        totalItensBiblioteca++;
    }

    // Métodos de acesso
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

    public static int getTotalItensBiblioteca() {
        return totalItensBiblioteca;
    }

    // Sobreposição dos métodos
    @Override
    public String toString() {
        return "ItemBiblioteca{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) return true;
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) return false;

        ItemBiblioteca outro = (ItemBiblioteca) outroObjeto;

        if (anoPublicacao != outro.anoPublicacao) return false;
        if (titulo != null ? !titulo.equals(outro.titulo) : outro.titulo != null) return false;
        return autor != null ? autor.equals(outro.autor) : outro.autor == null;
    }

    // Métodos abstratos
    public abstract double calcularMulta();
    public abstract boolean verificarDisponibilidade();

    // Método print()
    public void print() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + anoPublicacao);
    }
}
