import Polymorphism.Man;
import Polymorphism.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetterAndSetters {

    private Man man;
    private Woman woman;

    @Test
    public void gettersMethodManTest() {
        man = new Man("Sasha", "Pozenko", 60);

        Assert.assertEquals(man.getFirstName(), "Sasha", "Выполнение метода getFirstName для класса Man");
        Assert.assertEquals(man.getLastName(), "Pozenko", "Выполнение метода getLastName для класса Man");
        Assert.assertEquals(man.getAge(), 60, "Выполнение метода getAge для класса Man");
        Assert.assertNull(man.getPartner(), "Выполнение метода getPartner для класса Man");
    }

    @Test
    public void settersMethodManTest() {
        man = new Man("Sasha", "Pozenko", 60);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.setFirstName("kaka");
        Assert.assertEquals(man.getFirstName(), "kaka", "Выполнение метода setFirstName для класса Man");
        man.setLastName("Andrey");
        Assert.assertEquals(man.getLastName(), "Andrey", "Выполнение метода setLastName для класса Man");
        man.setAge(123);
        Assert.assertEquals(man.getAge(), 123, "Выполнение метода setAge для класса Man");
        man.setPartner(woman);
        Assert.assertEquals(man.getPartner(), woman, "Выполнение метода setPartner для класса Man");
    }

    @Test
    public void gettersMethodWomanTest() {
        woman = new Woman("Oksana", "Zhmih", 15);

        Assert.assertEquals(woman.getFirstName(), "Oksana", "Выполнение метода getFirstName для класса Man");
        Assert.assertEquals(woman.getLastName(), "Zhmih", "Выполнение метода getLastName для класса Man");
        Assert.assertNull(woman.getOldLastName(), "Выполнение метода getOldLastName для класса Man");
        Assert.assertEquals(woman.getAge(), 15, "Выполнение метода getAge для класса Man");
        Assert.assertNull(woman.getPartner(), "Выполнение метода getPartner для класса Man");
    }

    @Test
    public void settersMethodWomanTest() {
        woman = new Woman("Oksana", "Zhmih", 15);
        man = new Man("Sasha", "Pozenko", 60);

        woman.setFirstName("Dada");
        Assert.assertEquals(woman.getFirstName(), "Dada", "Выполнение метода setFirstName для класса Woman");
        woman.setLastName("Andrey");
        Assert.assertEquals(woman.getLastName(), "Andrey", "Выполнение метода setLastName для класса Woman");
        woman.setOldLastName("NewLast");
        Assert.assertEquals(woman.getOldLastName(), "NewLast", "Выполнение метода setOldLastName для класса Woman");
        woman.setAge(123);
        Assert.assertEquals(woman.getAge(), 123, "Выполнение метода setAge для класса Woman");
        woman.setPartner(man);
        Assert.assertEquals(woman.getPartner(), man, "Выполнение метода setPartner для класса Woman");
    }
}
