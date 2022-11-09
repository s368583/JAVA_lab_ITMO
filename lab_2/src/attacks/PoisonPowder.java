package attacks;
import ru.ifmo.se.pokemon.*;

public class PoisonPowder extends StatusMove {
    public PoisonPowder() {
        super(Type.POISON, 0, 75);
    }

    @Override
    protected String describe() {
        return "использует Poison Powder - Отравленные покемоны теряют 1/8 своего максимального здоровья каждый ход";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        if (pokemon.getCondition().equals(Status.POISON)){
            Effect PoisonPowderEffect = new Effect().chance(1).turns(-1).stat(Stat.HP, -(int)(pokemon.getHP()/8));
            pokemon.addEffect(PoisonPowderEffect);
        }
    }
}