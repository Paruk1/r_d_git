package Enums;

public enum Planet {
    MERCURY(null,"VENUS", 0.0, 1),
    VENUS("MERCURY","EARTH", 2.3, 2),
    EARTH("VENUS","MARS", 4.5, 3),
    MARS("EARTH","JUPITER", 5.6, 4),
    JUPITER("MARS","SATURN", 7.5, 5),
    SATURN("JUPITER","URANUS", 3.3, 6),
    URANUS("SATURN","NEPTUNE", 3.2, 7),
    NEPTUNE("URANUS",null, 0.1, 8);

    private final String prevName;
    private final String nextName;
    private final double radius;
    private final double distanceFromSun;
    private final double distanceFromPrevPlanet;

    public double getDistanceFromPrevPlanet() {
        return distanceFromPrevPlanet;
    }
    private String getPrevName() {
        return prevName;
    }
    private String getNextName() {
        return nextName;
    }
    public double getRadius() {
        return radius;
    }


    Planet(String prevName, String nextName, double radius, double distanceFromPrevPlanet){
        this.nextName = nextName;
        this.prevName = prevName;
        this.radius = radius;
        this.distanceFromPrevPlanet = distanceFromPrevPlanet;
        distanceFromSun = count() + 10;
    }

    public int count(){
        return this.ordinal() + 1; //для удобства добавляю 1
    }

    public Planet getPrevious(){
        return Planet.valueOf(this.getPrevName());
    }

    public Planet getNext(){
        return Planet.valueOf(this.getNextName());
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }
}
