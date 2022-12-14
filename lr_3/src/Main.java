import location.enums.BuildingType;
import location.subclasses.Building;
import location.subclasses.City;
import location.subclasses.Street;

import person.enums.HairStyleTypeShorty;
import person.subclasses.Policeman;
import person.subclasses.Shorty;
//ЕДИНСТВЕННАЯ ПРОБЛЕМА: не работает sound от location!!!!


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

        System.out.println("Произошло ограбление банка");


        Shorty Nolik = new Shorty("Нолик", HairStyleTypeShorty.HAIRY);
        Nolik.changeHair(Nolik);
        Shorty Simka = new Shorty("Симка", HairStyleTypeShorty.HAIRY);
        Simka.changeHair(Simka);
        Shorty Papus = new Shorty("Папус", HairStyleTypeShorty.HAIRY);
        Papus.changeHair(Papus);
        Shorty Kusachka = new Shorty("Кусачка", HairStyleTypeShorty.HAIRY);
        Kusachka.changeHair(Kusachka);
        Shorty Shpula = new Shorty("Шпуля", HairStyleTypeShorty.HAIRY);
        Shpula.changeHair(Shpula);



        Policeman Digl = new Policeman("Дигль");
        Digl.changeHair(Digl);
        Policeman Gigl = new Policeman("Гигль");
        Gigl.changeHair(Gigl);
        Policeman Spigl = new Policeman("Спигль");
        Spigl.changeHair(Spigl);
        Policeman p4 = new Policeman("Пшигль");
        p4.changeHair(p4);
        Policeman p5 = new Policeman("Псигль");
        p5.changeHair(p5);

        System.out.println("На следующий день");

        Nolik.move(st2);
        Simka.move(st1);
        Papus.move(st1);
        Kusachka.move(st1);
        Shpula.move(st1);
        Digl.patrol(st1);
        Gigl.patrol(st3);
        Spigl.patrol(st4);
        p4.patrol(st5);
        p5.patrol(st6);


    }
}