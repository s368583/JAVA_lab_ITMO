package person;

import location.Location;

import location.enums.LocationType;
import location.subclasses.Street;
import person.interfaces.ChangeHair;
import person.interfaces.Feelings;
import person.interfaces.SoundAction;


public abstract class Person implements Feelings, SoundAction, ChangeHair {
    private String name;
    private Location location;


    public Person(String name) {
        this.name = name;


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


    public void move(Location location) {
        if (this.location != null) {
            this.location.removePerson(this);

        }
        location.addPerson(this);
        setLocation(location);
        if (location.getLocationType().equals(LocationType.STREET)) {
            ((Street)location).safe();
        }
        }

    public void chase(Location location) {
        if (this.location != null) {
            this.location.removePerson(this);

        }
        location.addPerson(this);
        setLocation(location);
    }
}


