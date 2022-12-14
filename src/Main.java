import location.subclasses.*;
import person.enums.HairStyle;
import person.subclasses.*;


public class Main {

    public static void main(String[] args) {
        City spb = new City("город N");
        Street st1 = new Street("Ломоносова", spb);
        Street st2 = new Street("Чайковского", spb);
        Street st3 = new Street("Гривцова", spb);
        Street st4 = new Street("Кронверский проспект", spb);
        Street st5 = new Street("Биржевая улица", spb);
        Building jail = new Building("Кресты", spb, st1);
        spb.setJail(jail);


        Shorty a = new Shorty("Нолик", HairStyle.HAIR);
        a.move(st1);
        Shorty b = new Shorty("Симка", HairStyle.HAIR);
        b.move(st1);
        Shorty c = new Shorty("Папус", HairStyle.BALD);
        c.move(st1);
        Shorty d = new Shorty("Кусачка", HairStyle.BALD);
        d.move(st1);
        Shorty e = new Shorty("Шпуля", HairStyle.HAIR);
        e.move(st1);
        Policeman p1 = new Policeman("Дигль", HairStyle.HAIR);
        p1.patrol(st1);
        Policeman p2 = new Policeman("Гигль", HairStyle.BALD);
        p2.patrol(st2);
        Policeman p3 = new Policeman("Спигль", HairStyle.HAIR);
        p3.patrol(st3);
        Policeman p4 = new Policeman("Пшигль", HairStyle.BALD);
        p4.patrol(st4);
        Policeman p5 = new Policeman("Псигль", HairStyle.HAIR);
        p5.patrol(st5);

    }
}