package attacks;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class PoisonJab extends PhysicalMove {
    public PoisonJab() {
        super(Type.POISON, 80, 100);
    }

    @Override
    protected String describe() {
        return "использует Poison Jab - наносит урон и имеет 30% шанс отравить цель";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        Effect PoisonJabEffect = new Effect().chance(0.3);
        pokemon.addEffect(PoisonJabEffect);
    }
}
