//12349
import pokemons.*;
import ru.ifmo.se.pokemon.*;


public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        b.addAlly(new Chatot("ъуъ", 2 ));
        b.addAlly(new Fomantis("Евангелион", 8));
        b.addAlly(new Lurantis("Гилев", 1));
        b.addFoe(new Bellsprout("ьйь", 3));
        b.addFoe(new Weepinbell("сон", 4));
        b.addFoe(new Victreebel("ы", 2));
        b.go();

    }
}









