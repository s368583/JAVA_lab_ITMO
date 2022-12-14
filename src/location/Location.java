package location;

import location.enums.LocationType;
import location.subclasses.*;
import person.Person;

import java.util.ArrayList;

public abstract class Location {
    private String name;
    private LocationType type;
    private Address address;
    private ArrayList<Person> persons = new ArrayList<>();




    public Address getAddress() {
        return address;
    }
    public ArrayList<Person> getPersons() {
        return persons;
    }

    public String getName() {
        return this.name;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Location(String name, LocationType type) {
        this.name = name;
        this.type = type;
    }

    public Person getRandomPerson () {
        return this.getPersons().get((int)(Math.floor(Math.random()*this.getPersons().size())));
    }

    public void addPerson(Person person) {
        if(address.getCity() != null) address.getCity().getPersons().add(person);
        if(address.getStreet() != null) address.getStreet().getPersons().add(person);
        if(address.getBuilding() != null) address.getBuilding().getPersons().add(person);
    }

    public void removePerson(Person person) {
        if(address.getCity() != null) address.getCity().getPersons().remove(person);
        if(address.getStreet() != null) address.getStreet().getPersons().remove(person);
        if(address.getBuilding() != null) address.getBuilding().getPersons().remove(person);
    }

}