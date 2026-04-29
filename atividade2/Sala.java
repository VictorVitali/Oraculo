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

    void adicionarSessao() {

        String horario = InOut.leString("Horario da sessao:");
        Sessao s = new Sessao(true, horario);

        sessoes.add(s);

        InOut.MsgDeInformacao("Sucesso", "Sessão criada!");
    }

    void listarSessoes() {

        String texto = "Sessoes:\n";

        for (Sessao s : sessoes) {
            texto += s + "\n";
        }

        InOut.MsgDeInformacao("Lista de Sessões", texto);
    }
}