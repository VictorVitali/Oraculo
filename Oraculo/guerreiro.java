import java.util.Random;

public class guerreiro {
    String nome;
    int qtdVidas;
    bolsa myBolsa;

    public guerreiro(String nome) {
        this.nome = nome;
        this.qtdVidas = sortearVidas();
        this.myBolsa = new bolsa();
    }

    public int sortearVidas() {
        Random random = new Random();
        return random.nextInt(4) + 9;
    }

    public void perderVida() {
        if (this.qtdVidas > 0) {
            this.qtdVidas--;
        }
    }

    public String vidaExtra() {
        return InOut.leString("Voce ficou sem vidas.\n Implore por sua vida:");
    }

    public void ganharVidaExtra() {
        this.qtdVidas++;
    }
}
