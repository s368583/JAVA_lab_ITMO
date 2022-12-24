package location.subclasses;

import location.Location;
import location.enums.BuildingType;
import location.enums.LocationType;
import person.subclasses.Shorty;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;


public class Street extends Location {
    private Building building;
    private City city;


    public Street(String name, City city) {
        super(name, LocationType.STREET);
        city.addStreet(this);
        super.setAddress(new Address(city,this,  (Building)null));
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

    /*public void safe (){
        if(building.getBuildingType().equals(BuildingType.HOUSE)) {
            System.out.println(this + " на этой улице нет тюрьмы, здесь безопасно" );
        }
    }*/

    public void checkPeople () throws Exception {
        int count = 0;
        for (int i = 0; i < this.getPersons().size(); i++) {
            if (this.getPersons().get(i) instanceof Shorty){
                count++;
            }
        }

        if(count == 0){
            class QuarantineException extends Exception {
                public QuarantineException () {
                    System.out.println("На " + getName() + " введен карантин из-за коронавируса. Все сидят дома, патрулировать улицу не имеет смысла");

                }
            }
            throw new QuarantineException();
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