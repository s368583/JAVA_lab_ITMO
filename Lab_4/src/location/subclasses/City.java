package location.subclasses;

import location.Location;
import location.enums.LocationType;
import person.Person;
import person.subclasses.Policeman;
import person.subclasses.Shorty;
import Exception.*;

import java.util.ArrayList;
import java.util.Objects;

public class City extends Location {
    public ArrayList<Street> streets = new ArrayList<>();
    private Building jail;
    private ArrayList<Person> persons = new ArrayList();

    public City(String name) {
        super(name, LocationType.CITY);
        super.setAddress(new Address(this, null, null));
        Weather.info();
    }

    public void checkPeople () throws RuntimeException {
        int count = 0;
        for (int i = 0; i < this.getPersons().size(); i++) {
            if (this.getPersons().get(i) instanceof Policeman){
                count++;
            }
        }

        if(count == 0){
            /*class StrikeException extends RuntimeException {
                public StrikeException () {
                    System.err.println("В городе нет ни одного полицейского. Они больше не хотят работать...");

                }
            }*/
            throw new StrikeException("В городе нет ни одного полицейского. Они больше не хотят работать...");
        }

    }
    static class Weather{
        public static void info(){
            int temp = (int)(Math.random()*15);
            int wind = (int)(Math.random()*10);
            int humidity = (int)(30 + Math.random()*70);
            System.out.println("температура " + temp + " градусов, ветер " + wind + " м/с, влажность " + humidity + " %");
        }
    }

    public Building getJail() {
        return this.jail;
    }

    public void setJail(Building jail) {
        this.jail = jail;
    }

    public void addStreet (Street street){
        streets.add(street);
    }

    public ArrayList<Street> getStreets() {
        return streets;
    }

    @Override
    public  void sound (String string){
        System.out.println("Топ-топ-топ. Еле слышно, как коротышка убегает");
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
