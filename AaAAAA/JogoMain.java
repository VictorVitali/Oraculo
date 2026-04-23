public class JogoMain {
    public static void main(String[] args) {
        guerreiro g = new guerreiro("Lucas");
        oraculo o = new oraculo();
    
        o.g = g;
        
        
        o.prologoIntroducao();
        o.loadLevel01();
    }
    
}
