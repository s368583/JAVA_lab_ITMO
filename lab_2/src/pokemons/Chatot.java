package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;


public class Chatot extends Pokemon {
    public Chatot(String name, int level) {
        super(name, level);

        setType(Type.NORMAL, Type.FLYING);
        setStats(76, 65, 45, 92, 42, 91);
        addMove(new Peck());
        addMove(new WorkUp());
        addMove(new DoubleTeam());
        addMove(new Roost());
    }


            }

