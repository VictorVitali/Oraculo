public class JogoMain {
    public static void main(String[] args) {
        guerreiro g = new guerreiro("Lucas", 10, myBolsa);
        oraculo o = new oraculo();
    
        o.g = g;
    
        o.loadLevel01();
    }
}
