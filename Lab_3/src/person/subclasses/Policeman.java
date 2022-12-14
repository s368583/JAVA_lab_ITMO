package person.subclasses;

import location.subclasses.Street;
import person.Person;
import person.helper.RealHair;
import person.helper.Wig;

import java.util.Objects;

public class Policeman extends Person {
    public Policeman(String name) {
        super(name);
    }


    public void pullHair(Person person) {
        if (person instanceof  Shorty) {
            Shorty shorty = (Shorty) person;
            System.out.println(this + " подёргал за волосы " + shorty);
            if (shorty.getWigable().getClass() == Wig.class) {
                System.out.print(this.getName());
                shorty.getWigable().testHair(shorty);
                if (interrogate(shorty)) {
                    System.out.println(shorty + " не смог доказать свою невиновность");
                    jail(shorty);
                } else {
                    System.out.println(shorty + " доказал свою невиновность и был отпущен");
                    Person pers = getLocation().getRandomPerson();
                    if (!pers.equals(shorty) && !pers.equals(this))
                        pers.reaction("был отпущен");
                    reaction("был отпущен");
                }
            } else if (shorty.getWigable().getClass() == RealHair.class){
                System.out.print(this.getName());
                shorty.getWigable().testHair(shorty);
                System.out.println(shorty + " оказался не лысым");
                shorty.scream();
            }
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
        Person pers = getLocation().getRandomPerson();
        if (!pers.equals(person) && !pers.equals(this))
            pers.reaction("допросил");
        return(Math.random() > 0.5);

    }


    public void jail(Person person) {
        System.out.println(person + " сел в тюрьму");
        Person pers = getLocation().getRandomPerson();
        if (!pers.equals(person) && !pers.equals(this))
            pers.reaction("сел в тюрьму");
        person.move(person.getLocation().getAddress().getCity().getJail());
        reaction("сел в тюрьму");
    }


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
        return Objects.hash(this.getLocation());
    }

    @Override
    public String toString() {
        String name = this.getName();
        return "Полицейский " + name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Policeman that = (Policeman) o;
        return (this.getName()).equals(that.getName()) && this.getLocation().equals(that.getLocation());
    }


}