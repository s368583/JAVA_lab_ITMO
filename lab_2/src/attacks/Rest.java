package attacks;
import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Rest - Пользователь спит на 2 хода, но полностью исцеляетс";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect RestEffect = new Effect().chance(1).turns(-1).stat(Stat.HP, (int)pokemon.getHP());
        Effect RestEffect2 = new Effect().chance(1).turns(2).condition(Status.SLEEP);
        pokemon.addEffect(RestEffect);
        pokemon.addEffect(RestEffect2);
    }
}
