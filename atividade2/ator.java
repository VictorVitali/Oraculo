public class ator {

    int idAtor;
    String nome, papel;

    public ator(int idAtor, String nome, String papel) {
        this.idAtor = idAtor;
        this.nome = nome;
        this.papel = papel;
    }

    public String toString() {
        return idAtor + " - " + nome + " (" + papel + ")";
    }
}