package location.subclasses;

import location.Location;
import location.enums.LocationType;

import java.util.Objects;

public class Building extends Location {


    public Building(String name, City city, Street street) {
        super(name, LocationType.BUILDING);
        super.setAddress(new Address(city, street, this));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAddress(), this.getPersons(), this.getRandomPerson());
    }

    @Override
    public String toString() {
        String name = this.getName();
        City city = this.getAddress().getCity();
        Street street = this.getAddress().getStreet();
        return "Здание" + name +  "в городе " + city + " на улице " + street ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Building that = (Building) o;
        return (this.getName()).equals(that.getName())
                && (this.getAddress().getCity()).equals(that.getAddress().getCity())
                && (this.getAddress().getStreet()).equals(that.getAddress().getStreet());
    }
}