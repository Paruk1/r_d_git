package Enums;

public class Main {
    public static void main(String[] args) {
        System.out.println(Planet.MARS.count()); //номер в списке планет

        Planet previous = Planet.MARS.getPrevious();
        System.out.println(previous); //EARTH

        Planet next = Planet.MARS.getNext();
        System.out.println(next); //JUPITER

        System.out.println(Planet.MARS.getRadius()); //5.6
        System.out.println(Planet.MARS.getDistanceFromSun()); //14.0
        System.out.println(Planet.EARTH.getDistanceFromSun()); //13.0
        System.out.println(Planet.JUPITER.getDistanceFromSun()); //15.0
    }
}
