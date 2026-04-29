import java.util.ArrayList;

public class Filme {

    int idFilme;
    String titulo;
    long duracao;
    String genero;

    ArrayList<Ator> atores = new ArrayList<>();

    public Filme(int idFilme, String titulo, long duracao, String genero) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    void adicionarAtor() {

        int id = InOut.leInt("ID do ator:");
        String nome = InOut.leString("Nome do ator:");
        String papel = InOut.leString("Papel:");

        Ator a = new Ator(id, nome, papel);
        atores.add(a);

        InOut.MsgDeInformacao("Sucesso", "Ator adicionado!");
    }

    void listarAtores() {

        String texto = "Atores:\n";

        for (Ator a : atores) {
            texto += a + "\n";
        }

        InOut.MsgDeInformacao("Lista de Atores", texto);
    }

    public String toString() {
        return idFilme + " - " + titulo + " (" + genero + ")";
    }
}