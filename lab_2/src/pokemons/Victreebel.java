package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Victreebel extends Weepinbell {
    public Victreebel(String name, int level) {
        super(name, level);

        setType(Type.GRASS, Type.POISON);
        setStats(80, 105, 65, 100, 70, 70);
        addMove(new LeafStorm());
    }
}
