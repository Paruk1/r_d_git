package Polymorphism;

public class Man extends Person{
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public boolean isRetired() {
        return this.getAge() > 65;
    }

    @Override
    public void registerPartnership(Person person) {
        if(this.getPartner() != null || person.getPartner() != null){
            throw new IllegalArgumentException("Брак уже есть");
        }

        ((Woman)person).setOldLastName(person.getLastName()); //сохраняем старую фамилию
        person.setLastName(this.getLastName()); //присваиваем новую фамилию

        this.setPartner(person); //связывание партнеров
        person.setPartner(this);

        System.out.println("Вы " + this.getFirstName() + " " + this.getLastName() +
                " успешно в браке с " + this.getPartner().getFirstName() + " " + this.getPartner().getLastName());
    }

    @Override
    public void deregisterPartnership(boolean unRegister) {
        if(unRegister) {
            this.getPartner().setLastName(((Woman)this.getPartner()).getOldLastName());
            ((Woman)this.getPartner()).setOldLastName(null);
        }
        this.getPartner().setPartner(null);
        this.setPartner(null);

        System.out.println("Вы успешно разведены " + this.getLastName());
    }
}
