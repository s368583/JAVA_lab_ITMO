package location.subclasses;

import location.Location;
import location.enums.LocationType;

import java.util.Objects;


public class Street extends Location {

    public Street(String name, City city) {
        super(name, LocationType.STREET);
        super.setAddress(new Address(city, this, null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAddress(), this.getPersons(), this.getRandomPerson());
    }

    @Override
    public String toString() {
        String name = this.getName();
        City city = this.getAddress().getCity();
        return "Улица " + name + " в городе " + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Street that = (Street) o;
        return (this.getName()).equals(that.getName())
                && (this.getAddress().getCity()).equals(that.getAddress().getCity());
    }
}