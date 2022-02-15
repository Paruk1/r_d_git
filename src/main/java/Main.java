public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 0;
        int d = 1;
        int summ1,summ2;

        summ1 = a + b;
        summ2 = c + d;
        System.out.printf("Результат сравнения: %s \n", compareSumm(summ1,summ2));
        summ1++; // 4
        summ2 -= 2; // -1
        System.out.printf("Результат сравнения x2: %s \n", compareSumm(summ1,summ2));
        System.out.printf("Хотя бы одна сумма кратна 2: %s", multiplicityTwo(summ1,summ2));
    }

    public static boolean compareSumm(int a,int b){
        return a > b;
    }

    public static boolean multiplicityTwo(int a,int b){
        return a%2 == 0 || b%2 ==0;
    }
}
