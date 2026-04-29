import java.util.ArrayList;

public class Sessao {

    boolean statusSessao;
    String horario;

    ArrayList<Filme> filmes = new ArrayList<>();

    public Sessao(boolean statusSessao, String horario) {
        this.statusSessao = statusSessao;
        this.horario = horario;
    }

    void adicionarFilme() {

        int id = InOut.leInt("ID do filme:");
        String titulo = InOut.leString("Titulo:");
        long duracao = InOut.leLong("Duracao:");
        String genero = InOut.leString("Genero:");

        Filme f = new Filme(id, titulo, duracao, genero);
        filmes.add(f);

        InOut.MsgDeInformacao("Sucesso", "Filme adicionado!");
    }

    void listarFilmes() {

        String texto = "Filmes:\n";

        for (Filme f : filmes) {
            texto += f + "\n";
        }

        InOut.MsgDeInformacao("Lista de Filmes", texto);
    }

    public String toString() {
        return "Sessão: " + horario;
    }
}