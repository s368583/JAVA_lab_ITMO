package person;

import location.Location;
import person.interfaces.*;


public abstract class Person implements Movable, Reaction {
    private String name;
    private Location location;

    public Person(String name) {
        this.name = name;

    }

    public void scream() {
        System.out.println(this + ": АААААААААААААААААААЙ, больно");
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void move(Location location) {
        if(this.location != null)
            this.location.removePerson(this);
        location.addPerson(this);
        setLocation(location);
    }


}