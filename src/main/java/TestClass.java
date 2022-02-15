public class TestClass {

    private final int age = 20; //предопределенный параметр

    public String getAge() {
        return String.format("---<%d>---",this.age); //создаем объект String в передаваемом параметре
    }
}
