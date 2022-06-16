package Polymorphism;

public class Woman extends Person {

    private String oldLastName;

    public String getOldLastName() {
        return oldLastName;
    }

    public void setOldLastName(String oldLastName) {
        this.oldLastName = oldLastName;
    }

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.getAge() > 60;
    }

    @Override
    public void registerPartnership(Person person) {
        if(this.getPartner() != null || person.getPartner() != null){
            System.out.println("Брак уже есть....");
        }

        this.oldLastName = this.getLastName(); //сохраняем старую фамилию
        this.setLastName(person.getLastName()); //присваиваем новую фамилию

        this.setPartner(person); //связывание партнеров
        person.setPartner(this);

        System.out.println("Вы " + this.getFirstName() + " " + this.getLastName() +
                " успешно в браке с " + this.getPartner().getFirstName() + " " + this.getPartner().getLastName());
    }

    @Override
    public void deregisterPartnership(boolean unRegister) {
        if(unRegister) {
            this.setLastName(this.getOldLastName());
            this.setOldLastName(null);
        }
        this.getPartner().setPartner(null);
        this.setPartner(null);
        System.out.println("Вы успешно разведены " + this.getLastName());
    }
}
