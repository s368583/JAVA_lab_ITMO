package attacks;
import ru.ifmo.se.pokemon.*;

public class SludgeBomb extends SpecialMove {
    public SludgeBomb() {
        super(Type.POISON, 90, 100);
    }

    @Override
    protected String describe() {
        return "использует Sludge Bomb - с вероятностью 30% отравляет цель";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        Effect SludgeBombEffect = new Effect().chance(0.3).turns(-1);
        pokemon.addEffect(SludgeBombEffect);
    }
}