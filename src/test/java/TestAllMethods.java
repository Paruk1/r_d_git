import Polymorphism.Man;
import Polymorphism.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAllMethods {

    private Man man;
    private Woman woman;

    @DataProvider(name = "manTestData")
    public Object[][] getTestDataMan() {
        return new Object[][]{
                {50, false},
                {80, true}
        };
    }

    @DataProvider(name = "womanTestData")
    public Object[][] getTestDataWoman() {
        return new Object[][]{
                {59, false},
                {61, true}
        };
    }

    @Test(dataProvider = "manTestData")
    public void isRetiredManTest(int age, boolean isRetiredExpect) {
        man = new Man("Sasha", "Pozenko", 70);

        man.setAge(age);

        Assert.assertEquals(man.isRetired(), isRetiredExpect);
    }


    @Test(dataProvider = "womanTestData")
    public void isRetiredWomanTest(int age, boolean isRetiredExpect) {
        woman = new Woman("Oksana", "Zhmih", 15);

        woman.setAge(age);

        Assert.assertEquals(woman.isRetired(), isRetiredExpect);
    }
}
