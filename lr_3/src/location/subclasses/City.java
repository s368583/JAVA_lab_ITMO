package location.subclasses;

import location.Location;
import location.enums.LocationType;
import person.subclasses.Shorty;

import java.util.ArrayList;
import java.util.Objects;

public class City extends Location {
    public ArrayList<Street> streets = new ArrayList<>();

    public City(String name) {
        super(name, LocationType.CITY);
    }
    public void addStreet (Street street){
        streets.add(street);
    }

    public ArrayList<Street> getStreets() {
        return streets;
    }

    @Override
    public  void sound (String string){
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPersons(), this.getRandomPerson());
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
