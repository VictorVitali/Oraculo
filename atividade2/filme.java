import java.util.ArrayList;

public class filme {
    int idFilme; 
    String titulo, genero;
    long duracao;
    ArrayList<ator> atores = new ArrayList <>();
    
    public filme(int idFilme, String titulo, long duracao, String genero) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
    }

    public void adicionarAtor(ator ator) {
        atores.add(ator);
    }

    public String toString() {
        return idFilme + " - " + titulo + " (" + genero + ")";
    }
}
