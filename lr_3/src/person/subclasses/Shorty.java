package person.subclasses;


import location.subclasses.Building;
import location.subclasses.City;
import location.subclasses.Street;
import person.Person;
import person.enums.HairStyleTypeShorty;
import person.enums.SituationsType;
import person.interfaces.ChangeHair;

import java.util.Objects;

public class Shorty extends Person {
    private HairStyleTypeShorty hairStyleTypeShorty;



    public Shorty(String name, HairStyleTypeShorty hairStyleTypeShorty) {
        super(name);
        this.hairStyleTypeShorty = hairStyleTypeShorty;
    }

    public HairStyleTypeShorty getHairStyleType() {
        return hairStyleTypeShorty;
    }

    public void setHairStyleType(HairStyleTypeShorty hairStyleTypeShorty) {
        this.hairStyleTypeShorty = hairStyleTypeShorty;
    }

    public boolean run (){
        System.out.println(this + " попытался скрыться");
        boolean run = Math.random() > 0.5;
        if (run) {
            System.out.println(this + " удалось убежать");
            City city = ((Street)getLocation()).getСity();
            city.sound("свобода");
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
    public void changeHair (Person person){
        Shorty shorty = (Shorty) person;
        shorty.setHairStyleType(HairStyleTypeShorty.values()[(int)(Math.floor(Math.random()*(HairStyleTypeShorty.values().length)))]);
        System.out.println(shorty + " меняет прическу на " + shorty.getHairStyleType().toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash();
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




}