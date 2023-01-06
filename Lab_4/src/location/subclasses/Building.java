package location.subclasses;

import location.Location;
import location.enums.BuildingType;
import location.enums.LocationType;
import person.Person;

import java.util.ArrayList;
import java.util.Objects;

public class Building extends Location {
    private Street street;
    private ArrayList<Person> persons = new ArrayList<>();
    private BuildingType buildingType;

    public Building(String name, City city, Street street) {
        super(name, LocationType.BUILDING);
        super.setAddress(new Address(city, street, this));
    }

    /*public BuildingType getBuildingType() {
        return buildingType;
    }



    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }*/

    @Override
    public  void sound (String string){
        System.out.println("скрип-скрип... Это не старый трек Фараона, это звуки шагов нового заключенного в тюрьме");
        }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPersons(), this.getRandomPerson());
    }

    @Override
    public String toString() {
        String name = this.getName();
        return "Здание" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Building that = (Building) o;
        return (this.getName()).equals(that.getName());
    }
}