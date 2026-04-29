import java.util.Random;

public class oraculo {
    String nome;
    guerreiro guerreiro;
    int vidasPerdidas;
    int numeroSecretoLevel01;
    int vidasPerdidasLevel03;
    String palpitesLevel01 = "";
    String respostasLevel02 = "";
    String tentativasLevel03 = "";
    boolean vidaExtraPedida;
    boolean vidaExtraConcedida;
    Monstro monstro = new Monstro();
    Random random = new Random();

    public oraculo() {
        nome = "Oraculo";
    }

    void definirNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            this.nome = "Oraculo";
        } else {
            this.nome = nome;
        }
    }

    String prologoIntroducao() {
        String texto = "Seja bem vindo ao WAR, " + guerreiro.nome + "!\n"
                + "Eu sou " + nome + ".\n"
                + "Voce comeca com " + guerreiro.qtdVidas + " vidas.";

        mostrarMensagem("Prologo", texto);
        return texto;
    }

    String prologoPerdedor() {
        String texto = guerreiro.nome + ", voce perdeu o desafio do " + nome + ".";
        mostrarMensagem("Fim de jogo", texto);
        return texto;
    }

    String prologoVencedor() {
        String texto = "Meus parabens, " + guerreiro.nome + "!\n"
                + "Voce venceu o desafio do " + nome + ".";
        mostrarMensagem("Vencedor", texto);
        return texto;
    }

    boolean loadLevel01() {
        java.util.Random random = new java.util.Random();

        numeroSecretoLevel01 = random.nextInt(99) + 1;

        mostrarMensagem("Level 01", "Adivinhe o numero secreto entre 1 e 100.");

        while (guerreiro.qtdVidas > 0) {
            int chute = InOut.leInt("Level 01\nVidas: " + guerreiro.qtdVidas
                    + "\nEscolha um numero entre 1 e 100:");

            palpitesLevel01 = palpitesLevel01 + ", " + chute;

            if (chute == numeroSecretoLevel01) {
                mostrarMensagem("Level 01", "Acertou o numero secreto!");
                return true;
            } else if (chute < numeroSecretoLevel01) {
                mostrarMensagem("Dica", "O segredo é MAIOR que o palpite.");
            } else {
                mostrarMensagem("Dica", "O segredo é MENOR que o palpite.");
            }

            perderUmaVida();
        }

        return false;
    }

    boolean loadLevel02() {
        //NÃO COLOQUEI PRA TENTAR NOVAMENTE PQ SE O CARA NAO SOUBER, VAI FICAR PRESO AQUI INFINITAMENTE.

        if (guerreiro.qtdVidas <= 0) {
            return false;
        }

        mostrarMensagem("Level 02", "Responda 3 charadas. Cada erro tira 1 vida.");

        perguntarCharada("Charada 1:\nO que e, o que e?\nQuanto mais seca, mais molhada fica?", "toalha");

        if (guerreiro.qtdVidas <= 0) {
            return false;
        }

        perguntarCharada("Charada 2:\nO que e, o que e?\nSempre te segue, mas some no escuro?", "sombra");

        if (guerreiro.qtdVidas <= 0) {
            return false;
        }

        perguntarCharada("Charada 3:\nO que e, o que e?\nRepete tudo que voce fala?", "eco");

        return guerreiro.qtdVidas > 0;
    }

    void perguntarCharada(String pergunta, String respostaCerta) {
    String resposta = InOut.leString(pergunta);

        respostasLevel02 = respostasLevel02 + "Digitada: " + resposta
                + " | Certa: " + respostaCerta + "\n";

        if (resposta != null && resposta.trim().equalsIgnoreCase(respostaCerta)) {
            mostrarMensagem("Charada", "Resposta correta!");
        } else {
            mostrarMensagem("Charada", "Resposta errada. A resposta certa era: " + respostaCerta);
            perderUmaVida();
        }
    }

    boolean loadLevel03() {
        mostrarMensagem("Level 03", "Batalha final:");
 
        String acao;

        while(monstro.qtdVidas > 0){
        acao = "";


        while (!acao.equalsIgnoreCase("D") && !acao.equalsIgnoreCase("A")) {
            acao = InOut.leString("O que fazer no turno? \n"
                                + "A = Ataque \n "
                                + "D = Defender\n"
                                + "O monstro ainda tem " + monstro.qtdVidas + " vidas \n"
                                + "Voce tem " + guerreiro.qtdVidas + " vidas\n"
                                + "O monstro tem " + monstro.getChanceDeAtaque() + "% de chance de atacar");
        }
        
            turno(acao);
        }

        return false;
    }

    String RelatorioFimGame() {
        String relatorio = 
                  "Relatorio final\n"
                + "Oraculo: " + nome + "\n"
                + "Guerreiro: " + guerreiro.nome + "\n"
                + "Vidas restantes: " + guerreiro.qtdVidas + "\n"
                + "Vidas perdidas: " + vidasPerdidas + "\n"
                + "Numero secreto do Level 01: " + numeroSecretoLevel01 + "\n"
                + "Palpites do Level 01: " + textoOuNenhum(palpitesLevel01) + "\n"
                + "Respostas do Level 02: " + textoOuNenhum(respostasLevel02) + "\n"
                + "Vidas perdidas no Boss Final: " + textoOuNenhum(tentativasLevel03) + "\n"
                + "Vida extra concedida: " + (vidaExtraConcedida ? "Sim" : "Nao");

        mostrarMensagem("Relatorio", relatorio);
        return relatorio;
    }

    void perderUmaVida() {
        guerreiro.perderVida();
        vidasPerdidas++;

        if (guerreiro.qtdVidas == 0 && !vidaExtraPedida) {
            vidaExtraPedida = true;

            String pedido = guerreiro.vidaExtra();

            decidirVidaExtra(pedido);
        }
    }

    boolean decidirVidaExtra(String frase) {
        if (frase == null) {
            return false;
        }

        String texto = frase.trim();

        if (texto.isEmpty()) {
            mostrarMensagem("Vida extra", "Pedido recusado. Texto vazio.");
            return false;
        }

        String[] palavras = texto.split("\\s+");

        if (palavras.length > 5) {
            guerreiro.ganharVidaExtra();
            vidaExtraConcedida = true;
            mostrarMensagem("Vida extra", "Pedido aceito. Voce ganhou 1 vida.");
            return true;
        } else {
            mostrarMensagem("Vida extra", "Pedido recusado. Use mais de 5 palavras.");
            return false;
        }
    }

    String textoOuNenhum(String texto) {
        if (texto == null || texto.trim().equals("")) {
            return "Nenhum";
        }

        return texto;
    }

    void mostrarMensagem(String titulo, String texto) {
        System.out.println(texto);
        InOut.MsgDeInformacao(titulo, texto);
    }
    
    boolean turno(String Acao){
        if("A".equals(Acao)){
            if(monstro.acaoDoTurno() == 'A'){
                mostrarMensagem("ATACOU", "O mosntro também te ATACOU");
                monstro.qtdVidas--;
                guerreiro.perderVida();
                guerreiro.perderVida();
                vidasPerdidasLevel03 = vidasPerdidasLevel03 + 2;
            }else{
                if (random.nextBoolean()) {
                    mostrarMensagem("DEFENDEU", "O monstro DEFENDEU seu ataque");
                } else {
                    mostrarMensagem("HIT", "O monstro tomou o dano.");
                    monstro.qtdVidas--;
                }
            }
        }
        else if("D".equals(Acao)){
            mostrarMensagem("DEFENDEU", "Você DEFENDEU seu ataque");
        }
        return true;
    }
    
}
