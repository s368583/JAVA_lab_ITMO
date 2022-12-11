package location.subclasses;

import location.subclasses.Building;
import location.Location;
import location.enums.LocationType;

public class City extends Location {
    private Building jail;


    public City(String name) {
        super(name, LocationType.CITY);
        super.setAddress(new Address(this, null, null));
    }


    public Building getJail() {
        return jail;
    }
    public void setJail(Building jail) {
        this.jail = jail;
    }
}
