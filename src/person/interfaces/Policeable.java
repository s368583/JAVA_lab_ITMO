package person.interfaces;

import location.subclasses.Street;
import person.Person;

public interface Policeable {
    void pullHair(Person person);
    void patrol(Street street);
    boolean interrogate(Person person);
    void jail(Person person);
}
