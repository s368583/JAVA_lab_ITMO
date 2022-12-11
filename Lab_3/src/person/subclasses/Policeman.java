package person.subclasses;

import location.subclasses.Street;
import person.Person;
import person.enums.HairStyle;

public class Policeman extends Person {
    public Policeman(String name, HairStyle hairStyle) {
        super(name, hairStyle);
    }

    public void pullHair(Person person) {
        System.out.println(this + " подёргал за волосы " + person);
        if(person.getHairStyle().equals(HairStyle.BALD)) {
            System.out.println(person + " оказался лысым и был отправлен на допрос");
            if(interrogate(person)) {
                System.out.println(person + " не смог доказать свою невиновность");
                jail(person);
            }
            else {
                System.out.println(person + " доказал свою невиновность и был отпущен");
            }
        }
        else {
            System.out.println(person + " оказался не лысым");
            person.scream();
        }
    }

    public void patrol(Street street) {
        System.out.println(this + " патрулирует улицу " + street);
        move(street);
        for (int i = 0; i < street.getPersons().size(); i++) {
            if (!(street.getPersons().get(i) instanceof Policeman)){
                pullHair(street.getPersons().get(i));
            }
        }
    }

    public boolean interrogate(Person person) {
        System.out.println(this + " допросил " + person);
        return(Math.random() > 0.5);
    }

    public void jail(Person person) {
        System.out.println(person + " сел в тюрьму");
        person.move(person.getLocation().getAddress().getCity().getJail());
    }
}