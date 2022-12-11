package location.subclasses;

import location.Location;
import location.enums.LocationType;

public class Building extends Location {


    public Building(String name, City city, Street street) {
        super(name, LocationType.BUILDING);
        super.setAddress(new Address(city, street, this));
    }
}