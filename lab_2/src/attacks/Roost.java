package attacks;
import ru.ifmo.se.pokemon.*;


public class Roost extends StatusMove {
    public Roost() {
        super(Type.FLYING, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Roost - восстанавливает половину своего максимального HP";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect RoostEffect = new Effect().chance(1).turns(-1).stat(Stat.HP, (int) pokemon.getHP() - (int)(pokemon.getHP()/2));
        pokemon.addEffect(RoostEffect);

    }

}