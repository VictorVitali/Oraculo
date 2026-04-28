/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alunolab10
 */
public class oraculo {
    String nome;
    guerreiro guerreiro;
    
    
    guerreiro g;
    
    public oraculo () {}
    
    void definirNome (String nome) {}
    
    String prologoIntroducao () {
        System.out.println("Bem Vindo " + g.nome + "Me chamo " + nome);
        System.out.println("Vamos jogar alguns jogos, sua quantidade de vidas é: " + g.qtdVidas);
        return " ";
    }
    
    String prologoPerdedor () {
        return "Você perdeu hahahahah";
    }
    
    String prologoVencedor () {
        return "Meus parabéns Guerreiro";
    }
    
    boolean loadLevel01() {
        java.util.Random random = new java.util.Random();
        
        int numeroSecreto = random.nextInt(99) + 1;
        
        while (g.qtdVidas > 0){
            int chute = InOut.leInt("Escolha um número");
                    
            if (chute == numeroSecreto) {
                System.out.println(prologoVencedor());
                return true;
            }
            else if (chute < numeroSecreto) {
                System.out.println("Maior!");
            }
            else {
                System.out.println("Menor!");
            }
            g.qtdVidas --;
            System.out.println("Vidas Restantes: " + g.qtdVidas); 
        }
        System.out.println(prologoPerdedor());
        return false;
    } 
    
    boolean loadLevel02() {
        return true;
    }
    
    boolean decidirVidaExtra(String frase) {
        if (frase.equalsIgnoreCase("vida extra")){
        }
        return false;
    }
}
