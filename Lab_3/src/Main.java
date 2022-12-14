import location.subclasses.*;
import person.helper.RealHair;
import person.helper.Wig;
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


        Shorty a = new Shorty("Нолик", new RealHair());
        a.move(st1);
        Shorty b = new Shorty("Симка", new Wig());
        b.move(st1);
        Shorty c = new Shorty("Папус", new Wig());
        c.move(st1);
        Shorty d = new Shorty("Кусачка", new RealHair());
        d.move(st1);
        Shorty e = new Shorty("Шпуля", new Wig());
        e.move(st1);
        Policeman p1 = new Policeman("Дигль");
        p1.patrol(st1);
        Policeman p2 = new Policeman("Гигль");
        p2.patrol(st2);
        Policeman p3 = new Policeman("Спигль");
        p3.patrol(st3);
        Policeman p4 = new Policeman("Пшигль");
        p4.patrol(st4);
        Policeman p5 = new Policeman("Псигль");
        p5.patrol(st5);

        p1.pullHair(a);

    }
}