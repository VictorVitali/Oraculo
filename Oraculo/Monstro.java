import java.util.Random;

public class Monstro {
    int qtdVidas = 5;
    char ultimaAcao = ' ';
    int sequencia = 0;
    Random random = new Random();

    public Monstro() {
        this.qtdVidas = 5;
    }

    public char acaoDoTurno() {

        if (sequencia == 0) {
            ultimaAcao = random.nextBoolean() ? 'A' : 'D';
            sequencia = 1;
            return ultimaAcao;
        }

        int chanceRepetir = calcularChanceDeRepetir();
        int r = random.nextInt(100);

        if (r < chanceRepetir) {
            sequencia++;
            return ultimaAcao;
        } else {
            ultimaAcao = (ultimaAcao == 'A') ? 'D' : 'A';
            sequencia = 1;
            return ultimaAcao;
        }
    }

    private int calcularChanceDeRepetir() {
        int baseChance = 50;
        int penalty = Math.min(sequencia, 4) * 10;

        return baseChance - penalty;
    }
    
    public int getChanceDeAtaque() {
        if (sequencia == 0) {
            return 50; // antes da primeira ação
        }

        int chanceRepetir = calcularChanceDeRepetir();

        if (ultimaAcao == 'A') {
            return chanceRepetir;
        } else {
            return 100 - chanceRepetir;
        }
    }
}