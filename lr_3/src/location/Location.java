package location;

import location.enums.LocationType;
import person.Person;
import person.interfaces.Feelings;
import person.interfaces.SoundAction;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Location implements SoundAction {
    private String name;
    private LocationType locationType;
    private ArrayList<Person> persons = new ArrayList<>();
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
        this.getPersons().add(person);
    }

    public void removePerson(Person person) {
        this.getPersons().remove(person);
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