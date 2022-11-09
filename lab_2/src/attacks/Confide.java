package attacks;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Confide - снижает специальную атаку цели на одну ступень";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        Effect ConfideEffect = new Effect().chance(1).turns(-1).stat(Stat.SPECIAL_ATTACK, -1);
        pokemon.addEffect(ConfideEffect);
    }
}