package location.subclasses;

public class Address {
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
