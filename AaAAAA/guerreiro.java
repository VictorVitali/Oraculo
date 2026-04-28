
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alunolab10
 */
public class guerreiro {
    String nome; 
    int qtdVidas;
    bolsa myBolsa;

    public guerreiro(String nome) {
        this.nome = nome;
        this.qtdVidas = sortearVidas();
    }
    
    public int sortearVidas() {
        Random random = new Random();
        return random.nextInt(4) + 9;
    }
    
    public void perderVida() {
        this.qtdVidas--;
        if (this.qtdVidas == 0){
            this.vidaExtra();
        }
    }
    
    public void vidaExtra() {
        this.qtdVidas++;
    }
}
