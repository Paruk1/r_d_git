package Polymorphism;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Andruy","Parail",12);
        Man man1 = new Man("Sasha","Pozenko",70);

        Woman woman = new Woman("Oksana","Zhmih",15);
        Woman woman1 = new Woman("Larisa","Myha",70);

        System.out.println(man.isRetired());
        System.out.println(man1.isRetired());

        System.out.println(woman.isRetired());
        System.out.println(woman1.isRetired());

        man.registerPartnership(woman); //Вы Andruy Parail успешно в браке с Oksana Parail
        woman1.registerPartnership(man1); //Вы Larisa Pozenko успешно в браке с Sasha Pozenko

        man.deregisterPartnership(false); //Вы успешно разведены Parail


        woman1.deregisterPartnership(true); //Вы успешно разведены Myha - вернулась старая фамилия для жены - true

        woman1.registerPartnership(man1); //Вы Larisa Pozenko успешно в браке с Sasha Pozenko

        woman1.deregisterPartnership(false); //Вы успешно разведены Pozenko - не вернулось так как false
    }
}
