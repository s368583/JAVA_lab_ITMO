package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Weepinbell extends Bellsprout {
    public Weepinbell(String name, int level) {
        super(name, level);

        setType(Type.GRASS, Type.POISON);
        setStats(65, 90, 50, 85, 45, 55);
        addMove(new PoisonPowder());
    }
}
