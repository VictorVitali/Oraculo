public class JogoMain {
    public static void main(String[] args) {
        String nomeGuerreiro = InOut.leString("Digite o nome do Guerreiro:");

        if (nomeGuerreiro == null || nomeGuerreiro.trim().equals("")) {
            nomeGuerreiro = "Guerreiro";
        }

        guerreiro g = new guerreiro(nomeGuerreiro);
        oraculo o = new oraculo();

        o.definirNome("Oraculo Master");
        o.guerreiro = g;

        o.prologoIntroducao();

        boolean perdeu = false;

        if (o.loadLevel01()) {

            if (o.loadLevel02()) {

                if (o.loadLevel03()) {

                    o.prologoVencedor();

                }else{

                    perdeu = true;
                }

            }else{

            perdeu = true;
            }

        }else{

            perdeu = true;
            
        }

        if(perdeu){
            o.prologoPerdedor();
        }
        o.RelatorioFimGame();
    }
}
