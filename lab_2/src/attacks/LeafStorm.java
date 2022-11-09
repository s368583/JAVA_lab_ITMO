package attacks;

import ru.ifmo.se.pokemon.*;

public class LeafStorm extends SpecialMove {
    public LeafStorm() {
        super(Type.GRASS, 130, 90);
    }

    @Override
    protected String describe() {
        return "использует Leaf Storm - снижает специальную атаку пользователя на два этапа после атаки";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect LeafStormEffect = new Effect().chance(1).turns(1).stat(Stat.SPECIAL_ATTACK, -2);
        pokemon.addEffect(LeafStormEffect);
    }
}


