package pokemons;
import attacks.*;
import ru.ifmo.se.pokemon.*;
public class Lurantis extends Fomantis {
    public Lurantis(String name, int level) {
        super(name, level);

        setType(Type.GRASS);
        setStats(70, 105, 90, 80, 90, 45);
        addMove(new LowSweep());
    }
}
