import java.util.ArrayList;

public class filme {

    int idFilme;
    String titulo, genero;
    long duracao;

    ArrayList<ator> atores = new ArrayList<>();

    String historicoAtores = "";

    public filme(int idFilme, String titulo, long duracao, String genero) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    void adicionarAtor() {

        int id = InOut.leInt("ID do ator:");
        String nome = InOut.leString("Nome:");
        String papel = InOut.leString("Papel:");

        ator a = new ator(id, nome, papel);
        atores.add(a);

        historicoAtores += nome + " como " + papel + "\n";

        InOut.MsgDeInformacao("Sucesso", "Ator adicionado!");
    }

    void listarAtores() {

        String texto = "";

        for (ator a : atores) {
            texto += a + "\n";
        }

        InOut.MsgDeInformacao("Atores", texto);
    }

    public String toString() {
        return idFilme + " - " + titulo + " (" + genero + ")";
    }
}