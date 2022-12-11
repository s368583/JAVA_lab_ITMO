package location.subclasses;

import location.Location;
import location.enums.LocationType;


public class Street extends Location {

    public Street(String name, City city) {
        super(name, LocationType.STREET);
        super.setAddress(new Address(city, this, null));
    }
}