package person.subclasses;

import location.subclasses.Street;
import person.Person;
import person.enums.HairStyle;
import person.interfaces.Policeable;

import java.util.Objects;

public class Policeman extends Person implements Policeable {
    public Policeman(String name, HairStyle hairStyle) {
        super(name, hairStyle);
    }

    @Override
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
                Person pers = getLocation().getRandomPerson();
                if (!pers.equals(person) && !pers.equals(this))
                    pers.reaction("был отпущен");
                reaction("был отпущен");
            }
        }
        else {
            System.out.println(person + " оказался не лысым");
            person.scream();
        }
    }


    @Override
    public void patrol(Street street) {
        System.out.println(this + " патрулирует улицу " + street);
        move(street);
        for (int i = 0; i < street.getPersons().size(); i++) {
            if (!(street.getPersons().get(i) instanceof Policeman)){
                pullHair(street.getPersons().get(i));
            }
        }
    }

    @Override
    public boolean interrogate(Person person) {
        System.out.println(this + " допросил " + person);
        Person pers = getLocation().getRandomPerson();
        if (!pers.equals(person) && !pers.equals(this))
            pers.reaction("допросил");
        return(Math.random() > 0.5);

    }

    @Override
    public void jail(Person person) {
        System.out.println(person + " сел в тюрьму");
        Person pers = getLocation().getRandomPerson();
        if (!pers.equals(person) && !pers.equals(this))
            pers.reaction("сел в тюрьму");
        person.move(person.getLocation().getAddress().getCity().getJail());
        reaction("сел в тюрьму");
    }

    @Override
    public void reaction (String string) {
        switch (string) {
            case "сел в тюрьму":
                System.out.println(this + " радуется, что нашел преступника");
                break;
            case "был отпущен":
                System.out.println(this + " злится, что не поймал настоящего лысого");
                break;

        }

    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getHairStyle(), this.getLocation());
    }

    @Override
    public String toString() {
        String name = this.getName();
        HairStyle hairStyle = this.getHairStyle();
        return "Полицейский " + name +  " с волосами " + hairStyle;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Policeman that = (Policeman) o;
        return (this.getName()).equals(that.getName())
                && (this.getLocation()).equals(that.getLocation())
                && (this.getLocation()).equals(that.getLocation());
    }
}