package person.subclasses;

import location.subclasses.Street;
import person.Person;
import person.enums.SituationsType;
import person.helper.RealHair;
import person.helper.Wig;

import java.util.ArrayList;
import java.util.Objects;

public class Policeman extends Person {
    public Policeman(String name) {
        super(name);
    }

    public ArrayList<Shorty> interrogated = new ArrayList<>();


    public void pullHair(Person person) {
        if (person instanceof  Shorty) {
            Shorty shorty = (Shorty) person;
            System.out.println(this + " подёргал за волосы " + shorty);
            if (shorty.getWigable().getClass() == Wig.class) {
                //System.out.print(shorty.getName());
               // shorty.getWigable().testHair(shorty);
                //shorty.getWigable().hairstyle(shorty);
                shorty.sound("парик");
                this.sound("парик");
                if (shorty.run()){
                    this.feeling(SituationsType.RUN);
                    interrogated.add(shorty);
                }
                else { if (interrogate(shorty)) {
                    System.out.println(shorty + " не смог доказать свою невиновность");
                    jail(shorty);
                } else {
                    System.out.println(shorty + " доказал свою невиновность и был отпущен");
                    Person pers = getLocation().getRandomPerson();
                    //здесь нужен while, создать булиан
                    boolean test = true;
                    while ((!pers.equals(shorty) && !pers.equals(this)) && test){
                        pers.feeling(SituationsType.FREE);
                        test = false;
                    }

                    /*if (!pers.equals(shorty) && !pers.equals(this))
                        pers.feeling(SituationsType.FREE);
                    this.feeling(SituationsType.FREE);*/

                }}
            } else if (shorty.getWigable().getClass() == RealHair.class){
                System.out.print(shorty.getName());
                shorty.getWigable().testHair(shorty);
                shorty.getWigable().hairstyle(shorty);
                System.out.println(shorty + " оказался не лысым");
                shorty.sound("волосатый");
                this.sound("волосатый");
            }
        }
    }





    public void patrol(Street street) {
            System.out.println(this + " патрулирует " + street);
            chase(street);
            for (int i = 0; i < street.getPersons().size(); i++) {
                if (!(street.getPersons().get(i) instanceof Policeman)) {
                    if (!interrogated.contains(street.getPersons().get(i))){
                    pullHair(street.getPersons().get(i));
                }
            }
            }

    }

//run нужно делать до допроса
    public boolean interrogate(Shorty shorty) {
        if (!interrogated.contains(shorty)){
            System.out.println(this + " допросил " + shorty);
            Person pers = null;
            do {
                pers =  getLocation().getRandomPerson();
            }
            while ((pers.equals(shorty) || (pers instanceof Policeman)) && getLocation().getPersons().size() > 2);
            this.feeling(SituationsType.INTERROGATION);


            /*if (shorty.run()){
                interrogated.add((Shorty)pers);
            }*/
        }
        interrogated.add(shorty);
        return(Math.random() > 0.5);
    }


    public void jail(Person person, Building building) {
        System.out.println(person + " сел в тюрьму");
        jail(building).sound("тюрьма");
        Person pers = getLocation().getRandomPerson();
        if (!pers.equals(person) && !pers.equals(this))
            pers.feeling(SituationsType.JAIL);
        Street street = (Street) person.getLocation();
        person.chase(street.getBuilding());
        this.feeling(SituationsType.JAIL);

    }


    public void feeling(SituationsType feelingsType) {
        switch (feelingsType) {
            case JAIL:
                System.out.println(this + " радуется, что нашел преступника");
                break;
            case FREE:
                System.out.println(this + " злится, что не поймал настоящего лысого");
                break;
            case RUN:
                System.out.println(this + " в гневе, что от него сбежал преступник");

        }
    }

    @Override
    public  void  sound (String string) {
        switch (string) {
            case "парик":
                System.out.println(this + ": хмммм, думаю, у вас ненастоящие волосы");
                break;
            case "волосатый":
                System.out.println(this + ": расти большой, не будь лапшой. Всего доброго, до свидания!");
                break;
        }
    }

    @Override
    public void changeHair (Person person){


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