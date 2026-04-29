import java.util.ArrayList;

public class sessao {

    boolean statusSessao;
    String horario;

    ArrayList<filme> filmes = new ArrayList<>();

    String historicoFilmes = "";

    public sessao(boolean statusSessao, String horario) {
        this.statusSessao = statusSessao;
        this.horario = horario;
    }

    void adicionarFilme() {
        int id = InOut.leInt("ID do filme:");
        String titulo = InOut.leString("Titulo:");
        long duracao = InOut.leLong("Duracao:");
        String genero = InOut.leString("Genero:");

        filme f = new filme(id, titulo, duracao, genero);
        filmes.add(f);

        historicoFilmes += titulo + "\n";

        InOut.MsgDeInformacao("Sucesso", "Filme adicionado!");
    }

    void listarFilmes() {
        String texto = "Filmes:\n";

        if (filmes.size() == 0) {
            texto += "Nenhum filme.";
        } else {
            for (filme f : filmes) {
                texto += f + "\n";
            }
        }

        InOut.MsgDeInformacao("Lista", texto);
    }

    public String toString() {
        return "Sessao: " + horario;
    }
}