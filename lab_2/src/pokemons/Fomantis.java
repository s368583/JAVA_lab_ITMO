package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Fomantis extends Pokemon {
    public Fomantis(String name, int level) {
        super(name, level);

        setType(Type.GRASS);
        setStats(40, 55, 35, 50, 35, 35);
        addMove(new PoisonJab());
        addMove(new Rest());
        addMove(new Confide());
    }
}