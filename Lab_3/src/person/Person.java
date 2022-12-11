package person;

import location.Location;
import person.enums.HairStyle;
import person.interfaces.*;


public abstract class Person implements Movable, Speakable {
    private String name;
    private HairStyle hairStyle;
    private Location location;

    public Person(String name, HairStyle hairStyle) {
        this.name = name;
        this.hairStyle = hairStyle;
    }

    public void scream() {
        say("АААААААААААААААААААЙ, больно");
    }

    public HairStyle getHairStyle() {
        return hairStyle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void move(Location location) {
        try {
            this.location.removePerson(this);
        }
        catch (NullPointerException ignored) {}
        location.addPerson(this);
        setLocation(location);
    }

    @Override
    public void say (String phrases) {
        System.out.println(this + ": " + phrases);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return("[" + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1) + "] " + name);
    }
}