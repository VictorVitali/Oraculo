import java.util.ArrayList;

public class sala {

    int idSala, numAssentos;
    String tipoTela, localizacao;

    ArrayList<sessao> sessoes = new ArrayList<>();

    public sala(int idSala, int numAssentos, String tipoTela, String localizacao) {
        this.idSala = idSala;
        this.numAssentos = numAssentos;
        this.tipoTela = tipoTela;
        this.localizacao = localizacao;
    }

    void adicionarSessao(sessao s) {
        sessoes.add(s);
    }
}