package Polymorphism;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Person partner;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }
    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public abstract boolean isRetired();

    public abstract void registerPartnership(Person person);
    public abstract void deregisterPartnership(boolean unRegister);
}
