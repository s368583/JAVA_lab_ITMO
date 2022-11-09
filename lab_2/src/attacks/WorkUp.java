package attacks;
import ru.ifmo.se.pokemon.*;

public class WorkUp extends StatusMove {
    public WorkUp() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Work Up - повышает Атаку и Специальную Атаку пользователя на одну ступень каждая";
    }


    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect WorkUpEffect = new Effect().chance(1).turns(-1).stat(Stat.ATTACK, 1).stat( Stat.SPECIAL_ATTACK, 1);
        pokemon.addEffect(WorkUpEffect);
    }
}