package location;

import location.enums.LocationType;
import location.subclasses.Building;
import location.subclasses.City;
import location.subclasses.Street;
import person.Person;
import person.enums.SituationsType;
import person.interfaces.Feelings;
import person.interfaces.SoundAction;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Location implements SoundAction {
    private String name;
    private Address address;
    private LocationType locationType;
    private ArrayList<Person> persons = new ArrayList<>();

    public static class Address {
        private City city;
        private Street street;
        private Building building;

        public Address(City city, Street street, Building building) {
            this.city = city;
            this.street = street;
            this.building = building;
        }

        public City getCity() {
            return city;
        }
        public Street getStreet() {
            return street;
        }
        public Building getBuilding() {
            return building;
        }
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public ArrayList<Person> getPersons() {
        return persons;
    }

    public LocationType getLocationType() {
        return locationType;
    }


    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getName() {
        return this.name;
    }


    public Location(String name, LocationType locationType) {
        this.name = name;
        this.locationType = locationType;
    }

    public Person getRandomPerson () {
        return this.getPersons().get((int)(Math.floor(Math.random()*this.getPersons().size())));
    }

    public void addPerson(Person person) {
        //persons.add(person);
        if(address.getCity() != null) address.getCity().getPersons().add(person);
        if(address.getStreet() != null) address.getStreet().getPersons().add(person);
        if(address.getBuilding() != null) address.getBuilding().getPersons().add(person);
    }

    public void removePerson(Person person) {
        //persons.remove(person);
        if(address.getCity() != null) address.getCity().getPersons().remove(person);
        if(address.getStreet() != null) address.getStreet().getPersons().remove(person);
        if(address.getBuilding() != null) address.getBuilding().getPersons().remove(person);
    }









    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && locationType == location.locationType && Objects.equals(persons, location.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, locationType, persons);
    }
}