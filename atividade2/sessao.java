public class sessao {
    boolean statusSessao;
    String horario;

    public sessao(boolean statusSessao, String horario) {
        this.statusSessao = statusSessao;
        this.horario = horario;
    }

    public String toString() {
        return "Horario: " + horario + " | Ativa: " + statusSessao;
    }
}