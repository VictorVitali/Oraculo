public class Ator {

    int idAtor;
    String nome;
    String papel;

    public Ator(int idAtor, String nome, String papel) {
        this.idAtor = idAtor;
        this.nome = nome;
        this.papel = papel;
    }

    void alterarDados() {
        nome = InOut.leString("Novo nome do ator:");
        papel = InOut.leString("Novo papel do ator:");

        InOut.MsgDeInformacao("Sucesso", "Ator alterado!");
    }

    public String toString() {
        return "ID: " + idAtor + " | Nome: " + nome + " | Papel: " + papel;
    }
}
