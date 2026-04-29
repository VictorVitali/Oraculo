public class Main {

    public static void main(String[] args) {

        Sala sala = new Sala(1, 100, "IMAX", "Bloco A");

        // Sessão
        sala.adicionarSessao();

        // pegar primeira sessão
        Sessao sessao = sala.sessoes.get(0);

        // Filme
        sessao.adicionarFilme();

        // pegar primeiro filme
        Filme filme = sessao.filmes.get(0);

        // Ator
        filme.adicionarAtor();

        // Exibir tudo
        sala.listarSessoes();
        sessao.listarFilmes();
        filme.listarAtores();
    }
}