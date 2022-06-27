import Polymorphism.Man;
import Polymorphism.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAllMethods {

    private Man man;
    private Woman woman;


    @Test
    public void registerPartnershipTest() {

        man.registerPartnership(woman);


        Assert.assertEquals(man.getPartner(), woman);

    }

    @Test
    public void registerPartnershipTest2() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.registerPartnership(woman);

        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test
    public void registerPartnershipTest3() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.registerPartnership(woman);

        Assert.assertEquals(woman.getOldLastName(), "Zhmih");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = "Брак у вашего партнера уже есть")
    public void registerPartnershipTest4() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);
        Man man1 = new Man("Andrey", "Parail", 11);

        man1.registerPartnership(woman);

        man.registerPartnership(woman);
    }

    @Test(expectedExceptions = {IllegalStateException.class}, expectedExceptionsMessageRegExp = "Брак у вас уже есть")
    public void registerPartnershipTest5() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);
        Woman woman2 = new Woman("Oksana123132", "Zhmih123132", 15);

        man.registerPartnership(woman);

        man.registerPartnership(woman2);
    }

    @Test
    public void deregisterPartnershipTest() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.registerPartnership(woman);

        man.deregisterPartnership(false);

        Assert.assertNull(man.getPartner());
    }

    @Test
    public void deregisterPartnershipTest2() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.registerPartnership(woman);

        man.deregisterPartnership(false);

        Assert.assertNull(woman.getPartner());
    }

    @Test
    public void deregisterPartnershipTest3() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.registerPartnership(woman);

        man.deregisterPartnership(false);

        Assert.assertEquals(woman.getLastName(), "Pozenko");
    }

    @Test
    public void deregisterPartnershipTest4() {
        man = new Man("Sasha", "Pozenko", 70);
        woman = new Woman("Oksana", "Zhmih", 15);

        man.registerPartnership(woman);

        man.deregisterPartnership(true);

        Assert.assertEquals(woman.getLastName(), "Zhmih");
    }

    @Test
    public void isRetiredManTest() {
        man = new Man("Sasha", "Pozenko", 70);

        Assert.assertTrue(man.isRetired());
    }

    @Test
    public void isRetiredManTest2() {
        man = new Man("Sasha", "Pozenko", 60);

        Assert.assertFalse(man.isRetired());
    }

    @Test
    public void isRetiredWomanTest() {
        woman = new Woman("Oksana", "Zhmih", 70);

        Assert.assertTrue(woman.isRetired());
    }

    @Test
    public void isRetiredWomanTest2() {
        woman = new Woman("Oksana", "Zhmih", 15);

        Assert.assertFalse(woman.isRetired());
    }
}
