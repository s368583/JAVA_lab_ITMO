/*package person.helper;


import person.Person;
import person.enums.HairStyleType;
import person.interfaces.ChangeHair;
import person.subclasses.Shorty;

public class RealHair implements ChangeHair {
    @Override
    public void testHair(Person person) {
        System.out.println(" имеет настоящие волосы");
    }

    @Override
    public void hairstyle(Shorty shorty) {
        shorty.setHairStyleType(HairStyleType.values()[(int)(Math.floor(Math.random()*(HairStyleType.values().length)))]);
        System.out.println(shorty + " меняет прическу на " + shorty.getHairStyleType().toString());

    }
}*/
