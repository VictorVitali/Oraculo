import java.util.Random;
import java.util.ArrayList;

public class Monstro {
    int qtdVidas;
    ArrayList<Character> lastAction = new ArrayList<>();
    Random random = new Random();

    public Monstro(){
        this.qtdVidas = 5;
    }
    
    public char acaoDoTurno(){

        int r = random.nextInt(100);
        
        if (lastAction.isEmpty()){
            if (r >= 50) {
                lastAction.add('A');
                return 'A';
            }else{
                lastAction.add('D');
                return 'D';
            }
        }
        
        char last = lastAction.get(lastAction.size() - 1);
        int chance = lastAction.size() * 15;

        if (last == 'D'){
            chance = chance * -1;
        }
        if ((r + chance) >= 50) {
            if (last == 'A') {
                lastAction.add('A');
            } else {
                lastAction.clear();
                lastAction.add('A');
            }
            return 'A';
        }else{
            if (last == 'D') {
                lastAction.add('D');
            } else {
                lastAction.clear();
                lastAction.add('D');
            }
            return 'D';
        }
    }
    
}
