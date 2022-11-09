package attacks;

import ru.ifmo.se.pokemon.*;

public class LowSweep extends PhysicalMove {
    public LowSweep() {
        super(Type.FIGHTING, 65, 100);
    }

    @Override
    protected String describe() {
        return "использует Low Sweep - снижает скорость цели на одну ступень";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        Effect LowSweepEffect = new Effect().chance(1).turns(-1).stat(Stat.SPEED, -1);
        pokemon.addEffect(LowSweepEffect);
    }
}
