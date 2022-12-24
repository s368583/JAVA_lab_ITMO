package person;

import location.Location;

import location.enums.LocationType;
import location.subclasses.Street;
import person.enums.Content;
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
        /*if (location.getLocationType().equals(LocationType.STREET)) {
            ((Street)location).safe();*/
        }


    public void chase(Location location) {
        if (this.location != null) {
            this.location.removePerson(this);
        }
        location.addPerson(this);
        setLocation(location);
    }



    public void sendLetter (Content content) {
        class Letter{
            public Letter(Content content){
                if (content == content.USEFUL) {
                    System.out.println("пришло очень важное письмо, весь отдел полиции должен узнать о нем");
                }
                if (content == content.OFFENSIVE) {
                    System.out.println("пришло оскорбительное письмо от наглых лысых коротышек. Их нужно всех арестовать!");
                }
            }
        }
        new Letter(content);
    }
}


