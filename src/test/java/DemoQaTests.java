import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DemoQaTests {

    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AParail\\Desktop\\r_d_git\\src\\main\\resourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void openDemoElementsPageTest() {
        driver.get("https://demoqa.com/elements");


        Assertions.assertEquals("https://demoqa.com/elements", driver.getCurrentUrl(), "не попали на страницу Elements");


        WebElement buttons = driver.findElement(By.xpath("//span[contains(text(),\"Buttons\")]/.."));
        driverWait.until(ExpectedConditions.elementToBeClickable(buttons));
        buttons.click();

        Assertions.assertEquals("https://demoqa.com/buttons", driver.getCurrentUrl(), "не попали на страницу Buttons");

        WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));
        driverWait.until(ExpectedConditions.elementToBeClickable(clickMeBtn));
        clickMeBtn.click();

        WebElement textResult = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        System.out.println(textResult.getText() + " РЕЗУЛЬТАТ");
    }

    @Test
    public void openDemoWebTablesPageTest() {
        driver.get("https://demoqa.com/webtables");

        Assertions.assertEquals("https://demoqa.com/webtables", driver.getCurrentUrl(), "не попали на страницу webtables");

        WebElement addBtn = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        addBtn.click();

        List<String> listText = new ArrayList<>();
        listText.add("Andriy");
        listText.add("Parail");
        listText.add("parail@gmail.com");
        listText.add("20");
        listText.add("123123123");
        listText.add("bank");

        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement ageField = driver.findElement(By.xpath("//input[@id='age']"));
        WebElement salaryField = driver.findElement(By.xpath("//input[@id='salary']"));
        WebElement departmentField = driver.findElement(By.xpath("//input[@id='department']"));
        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));

        firstNameField.sendKeys(listText.get(0));
        lastNameField.sendKeys(listText.get(1));
        emailField.sendKeys(listText.get(2));
        ageField.sendKeys(listText.get(3));
        salaryField.sendKeys(listText.get(4));
        departmentField.sendKeys(listText.get(5));

        submitBtn.submit();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchBox']")); //чтобы упростить код, делаю поиск записи по уникальному названию почты.
        searchBox.sendKeys(listText.get(2));

        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']")); //получаю массив записей
        List<WebElement> fields = rows.get(0).findElements(By.xpath(".//div[@class='rt-td']")); //с массива записей беру 1 где должна быть наша запись.

        List<String> listResult = new ArrayList<>(); //в записи немного другой порядок отображения данных.
        listResult.add("Andriy");
        listResult.add("Parail");
        listResult.add("20");
        listResult.add("parail@gmail.com");
        listResult.add("123123123");
        listResult.add("bank");

        for (int i = 0; i < listResult.size(); i++) { //начинаю проверять поля которые ввел и те что записались в результате.
            Assertions.assertEquals(listResult.get(i), fields.get(i).getText());
        }

        WebElement updateBtn = rows.get(0).findElement(By.xpath(".//span[@id='edit-record-4']"));
        updateBtn.click();

        //еще раз индентифицирую элементы потому что падает ошибка если использовать со старыми переменными. якобы табличка в dom дереве уже не присутствует старая.
        //org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
        WebElement firstNameFieldNew = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastNameFieldNew = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement emailFieldNew = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement ageFieldNew = driver.findElement(By.xpath("//input[@id='age']"));
        WebElement salaryFieldNew = driver.findElement(By.xpath("//input[@id='salary']"));
        WebElement departmentFieldNew = driver.findElement(By.xpath("//input[@id='department']"));
        WebElement submitBtnNew = driver.findElement(By.xpath("//button[@id='submit']"));


        firstNameFieldNew.clear();
        lastNameFieldNew.clear();
        emailFieldNew.clear();
        ageFieldNew.clear();
        salaryFieldNew.clear();
        departmentFieldNew.clear();

        firstNameFieldNew.sendKeys("test");
        lastNameFieldNew.sendKeys("test");
        emailFieldNew.sendKeys("test@gmail.com");
        ageFieldNew.sendKeys("test");
        salaryFieldNew.sendKeys("123");
        departmentFieldNew.sendKeys("test");

        submitBtnNew.click();
    }

    @AfterTest
    public void finalSetup() {
        driver.quit();
    }

}
