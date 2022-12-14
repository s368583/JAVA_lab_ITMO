package person.subclasses;


import person.Person;
import person.interfaces.Wigable;

import java.util.Objects;

public class Shorty extends Person {
    private Wigable wigable;

    public Shorty(String name) {
        super(name);
    }

    public Shorty(String name, Wigable wigable) {
        super(name);
        this.wigable = wigable;
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

    public Wigable getWigable() {
        return wigable;
    }

    public void setWigable(Wigable wigable) {
        this.wigable = wigable;
    }
}