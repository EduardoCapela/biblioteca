
package projbiblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Livro extends ItemBiblioteca {
    private String editora;
    // Outros atributos específicos de Livro

    private boolean disponivel;
    private Date dataDevolucao;

    public Livro() {
        super();
        disponivel = true;
    }

    public Livro(String titulo, String autor, int anoPublicacao, String editora) {
        super(titulo, autor, anoPublicacao);
        this.editora = editora;
        disponivel = true;
    }

    public Livro(Livro outro) {
        super(outro);
        this.editora = outro.editora;
        this.disponivel = outro.disponivel;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Editora: " + editora);
    }

    @Override
    public double calcularMulta() {
        if (dataDevolucao == null) {
            return 0.0; // Não há multa se o livro não estiver emprestado
        } else {
            Date dataAtual = new Date();
            if (dataDevolucao.after(dataAtual)) {
                // O livro foi devolvido no prazo, não há multa
                return 0.0;
            } else {
                long atrasoMillis = dataAtual.getTime() - dataDevolucao.getTime();
                long diasAtraso = TimeUnit.MILLISECONDS.toDays(atrasoMillis);
                double multaPorDia = 0.50; // Valor da multa por dia de atraso
                double multaTotal = diasAtraso * multaPorDia;
                return multaTotal;
            }
        }
    }

    @Override
    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    @Override
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            // Definir a data de devolução para daqui a 15 dias
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 15);
            dataDevolucao = calendar.getTime();
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro não está disponível para empréstimo.");
        }
    }

    @Override
    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            dataDevolucao = null;
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Livro já está disponível.");
        }
    }
}
