package person.subclasses;


import location.subclasses.Street;
import person.Person;
import person.enums.SituationsType;
import person.enums.HairStyleType;
import person.interfaces.ChangeHair;

import java.util.Objects;

public class Shorty extends Person {
    private ChangeHair wigable;
    private HairStyleType hairStyleType;



    public Shorty(String name, ChangeHair wigable, HairStyleType hairStyleType) {
        super(name);
        this.wigable = wigable;
        this.hairStyleType = hairStyleType;
    }

    public HairStyleType getHairStyleType() {
        return hairStyleType;
    }

    public void setHairStyleType(HairStyleType hairStyleType) {
        this.hairStyleType = hairStyleType;
    }

    public boolean run (){
        System.out.println(this + " попытался скрыться");
        boolean run = Math.random() > 0.5;
        if (run) {
            System.out.println(this + " удалось убежать");

            Street street = null;
            do {
                street =  (((Street)(this.getLocation())).getСity().getStreets().get((int)(Math.floor(Math.random()*((Street)(this.getLocation())).getСity().getStreets().size()))));
            }
            while (((Street)(this.getLocation())).equals(street));
            this.chase(street);
        }
        else {
            System.out.println(this + " сбежать не удалось");
        }
        return run;
    }




    @Override
    public void feeling(SituationsType feelingsType) {
        switch (feelingsType) {
            case JAIL:
                System.out.println(this + " испугался");
                break;
            case FREE:
                System.out.println(this + " обрадовался");
                break;

        }
    }

    @Override
    public void sound (String string){
        switch (string) {
            case "волосатый":
                System.out.println( this + ": AAAAAAAAAAAAAAAAAAAAAAЙ, больно");
                break;
            case "парик":
                System.out.println(this + ": хи-хи, щекотно");
                break;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(wigable);
    }

    @Override
    public String toString() {
        String name = this.getName();
        return "Гражданин " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Shorty that = (Shorty) o;
        return (this.getName()).equals(that.getName())
                && (this.getLocation()).equals(that.getLocation());
    }

    public ChangeHair getWigable() {
        return wigable;
    }

    public void setWigable(ChangeHair wigable) {
        this.wigable = wigable;
    }


}