package attacks;
import ru.ifmo.se.pokemon.*;

public class Venoshock extends SpecialMove {
    public Venoshock() {
        super(Type.POISON, 65, 100);
    }

    @Override
    protected String describe() {
        return "использует Venoshock - Наносит двойной урон, если цель отравлена";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        if (pokemon.getCondition().equals(Status.POISON))
            applyOppDamage(pokemon, 130);
    }
}
