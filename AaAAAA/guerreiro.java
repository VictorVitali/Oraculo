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

    public guerreiro(String nome, int qtdVidas, bolsa myBolsa) {
        this.nome = nome;
        this.qtdVidas = qtdVidas;
        this.myBolsa = myBolsa;
    }
    
    String vidaExtra () {
        return " ";
    }
}
