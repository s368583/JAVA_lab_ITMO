package attacks;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Double Team - повышает Уклонение пользователя на одну ступень";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect doubleTeamEffect = new Effect().chance(1).turns(-1).stat(Stat.EVASION, 1);
        pokemon.addEffect(doubleTeamEffect);
    }
}