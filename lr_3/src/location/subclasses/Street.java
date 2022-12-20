package location.subclasses;

import location.Location;
import location.enums.BuildingType;
import location.enums.LocationType;

import java.util.Objects;


public class Street extends Location {
    private Building building;
    private City city;


    public Street(String name, City city) {
        super(name, LocationType.STREET);
        city.addStreet(this);
        this.city = city;
    }

    public Building getBuilding() {
        return building;
    }
    public City getСity() {
        return city;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void safe (){
        if(building.getBuildingType().equals(BuildingType.HOUSE)) {
            System.out.println(this + " на этой улице нет тюрьмы, здесь безопасно" );
        }
    }



    @Override
    public  void sound (String string){
        System.out.println("на улице раздался восторженный крик радости коротышки, не попавшего в тюрьму");
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPersons(), this.getRandomPerson());
    }

    @Override
    public String toString() {
        String name = this.getName();
        return "Улица" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Street that = (Street) o;
        return (this.getName()).equals(that.getName());
    }
}