import java.util.ArrayList;

public class Sala {

    int idSala;
    int numAssentos;
    String tipoTela;
    String localizacao;

    ArrayList<Sessao> sessoes = new ArrayList<>();

    public Sala(int idSala, int numAssentos, String tipoTela, String localizacao) {
        this.idSala = idSala;
        this.numAssentos = numAssentos;
        this.tipoTela = tipoTela;
        this.localizacao = localizacao;
    }

    void alterarDados() {
        numAssentos = InOut.leInt("Novo numero de assentos:");
        tipoTela = InOut.leString("Novo tipo de tela:");
        localizacao = InOut.leString("Nova localizacao:");

        InOut.MsgDeInformacao("Sucesso", "Sala alterada!");
    }

    void adicionarSessao() {
        String horario = InOut.leString("Horario da sessao:");

        int opcao = InOut.leInt("Status da sessao:\n1 - Aberta\n2 - Encerrada");
        boolean status = true;

        if (opcao == 2) {
            status = false;
        }

        Sessao sessao = new Sessao(status, horario);
        sessoes.add(sessao);

        InOut.MsgDeInformacao("Sucesso", "Sessao criada!");
    }

    void listarSessoes() {
        InOut.MsgDeInformacao("Lista de Sessoes", textoSessoes());
    }

    String textoSessoes() {
        String texto = "Sessoes da sala " + idSala + ":\n";

        if (sessoes.size() == 0) {
            texto += "Nenhuma sessao cadastrada.";
            return texto;
        }

        for (int i = 0; i < sessoes.size(); i++) {
            texto += (i + 1) + " - " + sessoes.get(i) + "\n";
        }

        return texto;
    }

    Sessao escolherSessao() {
        if (sessoes.size() == 0) {
            InOut.MsgDeAviso("Aviso", "Nao existe sessao cadastrada.");
            return null;
        }

        int numero = InOut.leInt(textoSessoes() + "\nDigite o numero da sessao:");

        if (numero < 1 || numero > sessoes.size()) {
            InOut.MsgDeErro("Erro", "Sessao nao encontrada.");
            return null;
        }

        return sessoes.get(numero - 1);
    }

    void alterarSessao() {
        Sessao sessao = escolherSessao();

        if (sessao != null) {
            sessao.alterarDados();
        }
    }

    void removerSessao() {
        Sessao sessao = escolherSessao();

        if (sessao != null) {
            sessoes.remove(sessao);
            InOut.MsgDeInformacao("Sucesso", "Sessao removida!");
        }
    }

    void listarTudo() {
        String texto = toString() + "\n\n";

        if (sessoes.size() == 0) {
            texto += "Nenhuma sessao cadastrada.";
        } else {
            for (int i = 0; i < sessoes.size(); i++) {
                texto += "Sessao " + (i + 1) + "\n";
                texto += sessoes.get(i).textoCompleto() + "\n";
            }
        }

        InOut.MsgDeInformacao("Relatorio UVV Flix", texto);
    }

    public String toString() {
        return "Sala " + idSala + " | Assentos: " + numAssentos + " | Tela: " + tipoTela
                + " | Localizacao: " + localizacao + " | Sessoes: " + sessoes.size();
    }
}
