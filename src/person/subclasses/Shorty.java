package person.subclasses;


import person.Person;
import person.enums.HairStyle;

import java.util.Objects;

public class Shorty extends Person {


    public Shorty(String name, HairStyle hairStyle) {
        super(name, hairStyle);
    }

    public void run (){
        boolean run = Math.random() > 0.5;
        if (run) {
            System.out.println(this + " удалось убежать");
        }
    }

    @Override
    public void reaction (String string) {
        switch (string) {
            case "допросил":
                System.out.println(this + " попытался скрыться");
                run();
                break;
            case "сел в тюрьму":
                System.out.println(this + " испугался");
                break;
            case "был отпущен":
                System.out.println(this + " обрадовался");
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
        return "Гражданин " + name +  " с волосами " + hairStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Shorty that = (Shorty) o;
        return (this.getName()).equals(that.getName())
                && (this.getLocation()).equals(that.getLocation())
                && (this.getLocation()).equals(that.getLocation());
    }

}