import java.util.ArrayList;

public class Sessao {

    boolean statusSessao;
    String horario;

    ArrayList<Filme> filmes = new ArrayList<>();

    public Sessao(boolean statusSessao, String horario) {
        this.statusSessao = statusSessao;
        this.horario = horario;
    }

    void alterarDados() {
        horario = InOut.leString("Novo horario da sessao:");

        int opcao = InOut.leInt("Status da sessao:\n1 - Aberta\n2 - Encerrada");
        if (opcao == 1) {
            statusSessao = true;
        } else {
            statusSessao = false;
        }

        InOut.MsgDeInformacao("Sucesso", "Sessao alterada!");
    }

    void adicionarFilme() {
        int id = InOut.leInt("ID do filme:");
        String titulo = InOut.leString("Titulo:");
        long duracao = InOut.leLong("Duracao em minutos:");
        String genero = InOut.leString("Genero:");

        Filme filme = new Filme(id, titulo, duracao, genero);
        filmes.add(filme);

        InOut.MsgDeInformacao("Sucesso", "Filme adicionado!");
    }

    Filme buscarFilme(int id) {
        for (Filme filme : filmes) {
            if (filme.idFilme == id) {
                return filme;
            }
        }

        return null;
    }

    Filme escolherFilme() {
        if (filmes.size() == 0) {
            InOut.MsgDeAviso("Aviso", "Nao existe filme cadastrado nesta sessao.");
            return null;
        }

        int id = InOut.leInt(textoFilmes() + "\nDigite o ID do filme:");
        Filme filme = buscarFilme(id);

        if (filme == null) {
            InOut.MsgDeErro("Erro", "Filme nao encontrado.");
        }

        return filme;
    }

    void alterarFilme() {
        Filme filme = escolherFilme();

        if (filme != null) {
            filme.alterarDados();
        }
    }

    void removerFilme() {
        Filme filme = escolherFilme();

        if (filme != null) {
            filmes.remove(filme);
            InOut.MsgDeInformacao("Sucesso", "Filme removido!");
        }
    }

    void listarFilmes() {
        InOut.MsgDeInformacao("Lista de Filmes", textoFilmes());
    }

    String textoFilmes() {
        String texto = "Filmes da sessao " + horario + ":\n";

        if (filmes.size() == 0) {
            texto += "Nenhum filme cadastrado.";
            return texto;
        }

        for (Filme filme : filmes) {
            texto += filme + "\n";
        }

        return texto;
    }

    String textoCompleto() {
        String texto = toString() + "\n";

        if (filmes.size() == 0) {
            texto += "  Nenhum filme cadastrado.\n";
            return texto;
        }

        for (Filme filme : filmes) {
            texto += "  " + filme + "\n";

            if (filme.atores.size() == 0) {
                texto += "    Nenhum ator cadastrado.\n";
            } else {
                for (Ator ator : filme.atores) {
                    texto += "    " + ator + "\n";
                }
            }
        }

        return texto;
    }

    public String toString() {
        String status = "Encerrada";

        if (statusSessao == true) {
            status = "Aberta";
        }

        return "Horario: " + horario + " | Status: " + status + " | Filmes: " + filmes.size();
    }
}
