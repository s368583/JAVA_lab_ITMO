import location.enums.BuildingType;
import location.subclasses.Building;
import location.subclasses.City;
import location.subclasses.Street;
import person.enums.HairStyleType;
import person.helper.RealHair;
import person.helper.Wig;
import person.subclasses.Policeman;
import person.subclasses.Shorty;
//не работает sound от location
//прописать интерфейс changeHair. изначально все волосатые

public class Main {

    public static void main(String[] args) {
        City spb = new City("город N");
        Street st1 = new Street(" Ломоносова", spb);
        Street st2 = new Street(" Чайковского", spb);
        Street st3 = new Street(" Гривцова", spb);
        Street st4 = new Street(" Кронверский проспект", spb);
        Street st5 = new Street(" Биржевая улица", spb);
        Street st6 = new Street(", на которой нет вероятности допсы", spb);
        Building jail = new Building("Кресты", BuildingType.JAIL);
        Building house = new Building("дом", BuildingType.HOUSE);
        st1.setBuilding(jail);
        st2.setBuilding(house);
        st3.setBuilding(house);
        st4.setBuilding(house);
        st5.setBuilding(house);
        st6.setBuilding(house);


        Shorty a = new Shorty("Нолик", new RealHair(), HairStyleType.HAIRY);
        a.move(st2);
        Shorty b = new Shorty("Симка", new Wig(), HairStyleType.HAIRY);
        b.move(st1);
        Shorty c = new Shorty("Папус", new Wig(), HairStyleType.HAIRY);
        c.move(st1);
        Shorty d = new Shorty("Кусачка", new RealHair(), HairStyleType.HAIRY);
        d.move(st1);
        Shorty e = new Shorty("Шпуля", new Wig(), HairStyleType.HAIRY);
        e.move(st1);
        Policeman p1 = new Policeman("Дигль");
        p1.patrol(st1);
        Policeman p2 = new Policeman("Гигль");
        p2.patrol(st3);
        Policeman p3 = new Policeman("Спигль");
        p3.patrol(st4);
        Policeman p4 = new Policeman("Пшигль");
        p4.patrol(st5);
        Policeman p5 = new Policeman("Псигль");
        p5.patrol(st6);


    }
}