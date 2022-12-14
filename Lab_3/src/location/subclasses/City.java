package location.subclasses;

import location.Location;
import location.enums.LocationType;

import java.util.Objects;

public class City extends Location {
    private Building jail;


    public City(String name) {
        super(name, LocationType.CITY);
        super.setAddress(new Address(this, null, null));
    }


    public Building getJail() {
        return jail;
    }
    public void setJail(Building jail) {
        this.jail = jail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAddress(), this.getPersons(), this.getRandomPerson());
    }

    @Override
    public String toString() {
        String name = this.getName();
        return "Город " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        City that = (City) o;
        return (this.getName()).equals(that.getName());
    }
}
