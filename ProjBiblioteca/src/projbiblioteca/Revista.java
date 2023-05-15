
package projbiblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Revista extends ItemBiblioteca {
    private String issn;
    private boolean disponivel;
    private Date dataDevolucao;

    public Revista() {
        super();
    }

    public Revista(String titulo, String autor, int anoPublicacao, String issn) {
        super(titulo, autor, anoPublicacao);
        this.issn = issn;
    }

    public Revista(Revista outro) {
        super(outro);
        this.issn = outro.issn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("ISSN: " + issn);
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
