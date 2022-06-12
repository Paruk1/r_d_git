package Enums;

public enum Planet {
    MERCURY(null, 0.0, 1),
    VENUS(MERCURY, 2.3, 2),
    EARTH(VENUS, 4.5, 3),
    MARS(EARTH, 5.6, 4),
    JUPITER(MARS, 7.5, 5),
    SATURN(JUPITER, 3.3, 6),
    URANUS(SATURN, 3.2, 7),
    NEPTUNE(URANUS, 0.1, 8);

    private final Planet prevName;
    private Planet nextName;
    private final double radius;
    private final double distanceFromSun;
    private final double distanceFromPrevPlanet;

    public double getDistanceFromPrevPlanet() {
        return distanceFromPrevPlanet;
    }
    private Planet getPrevName() {
        return prevName;
    }
    private Planet getNextName() {
        return nextName;
    }
    public double getRadius() {
        return radius;
    }


    Planet(Planet prevName, double radius, double distanceFromPrevPlanet){
        this.prevName = prevName;
        if (prevName != null) {
            prevName.nextName = this;
        }
        this.radius = radius;
        this.distanceFromPrevPlanet = distanceFromPrevPlanet;
        distanceFromSun = count() + 10;
    }

    public int count(){
        return this.ordinal() + 1; //для удобства добавляю 1
    }

    public Planet getPrevious(){
        return this.prevName;
    }

    public Planet getNext(){
        return this.nextName;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }
}
