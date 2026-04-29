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

    void alterarDados() {
        titulo = InOut.leString("Novo titulo:");
        duracao = InOut.leLong("Nova duracao em minutos:");
        genero = InOut.leString("Novo genero:");

        InOut.MsgDeInformacao("Sucesso", "Filme alterado!");
    }

    void adicionarAtor() {
        int id = InOut.leInt("ID do ator:");
        String nome = InOut.leString("Nome do ator:");
        String papel = InOut.leString("Papel:");

        Ator ator = new Ator(id, nome, papel);
        atores.add(ator);

        InOut.MsgDeInformacao("Sucesso", "Ator adicionado!");
    }

    Ator buscarAtor(int id) {
        for (Ator ator : atores) {
            if (ator.idAtor == id) {
                return ator;
            }
        }

        return null;
    }

    void alterarAtor() {
        if (atores.size() == 0) {
            InOut.MsgDeAviso("Aviso", "Nao existe ator cadastrado.");
            return;
        }

        int id = InOut.leInt(textoAtores() + "\nDigite o ID do ator que deseja alterar:");
        Ator ator = buscarAtor(id);

        if (ator == null) {
            InOut.MsgDeErro("Erro", "Ator nao encontrado.");
        } else {
            ator.alterarDados();
        }
    }

    void removerAtor() {
        if (atores.size() == 0) {
            InOut.MsgDeAviso("Aviso", "Nao existe ator cadastrado.");
            return;
        }

        int id = InOut.leInt(textoAtores() + "\nDigite o ID do ator que deseja remover:");
        Ator ator = buscarAtor(id);

        if (ator == null) {
            InOut.MsgDeErro("Erro", "Ator nao encontrado.");
        } else {
            atores.remove(ator);
            InOut.MsgDeInformacao("Sucesso", "Ator removido!");
        }
    }

    void listarAtores() {
        InOut.MsgDeInformacao("Lista de Atores", textoAtores());
    }

    String textoAtores() {
        String texto = "Atores do filme " + titulo + ":\n";

        if (atores.size() == 0) {
            texto += "Nenhum ator cadastrado.";
            return texto;
        }

        for (Ator ator : atores) {
            texto += ator + "\n";
        }

        return texto;
    }

    public String toString() {
        return "ID: " + idFilme + " | Titulo: " + titulo + " | Duracao: " + duracao
                + " min | Genero: " + genero + " | Atores: " + atores.size();
    }
}
