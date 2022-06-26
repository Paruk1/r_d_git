package exceptions;

public class Main {
    public static void main(String[] args) {
        Module module = new Module();

        try {
            //module.processPayment(-1, "USD", "123"); пример 1
            //module.processPayment(55, null, "123"); пример 2
            //module.processPayment(55, "asd", "123"); пример 3
            System.out.println(module.processPayment(55, "USD", "123") + " ответ успешный");
            System.out.println(module.processPayment(55, "USD", "123") + " ответ успешный");

        } catch (InvalidPaymentAmountException | BankProcessingFailedException ex) {
            if(ex instanceof InvalidPaymentAmountException){
                System.out.println("invalid payment amount ex" + ((InvalidPaymentAmountException) ex).getMessage());
            }
            if(ex instanceof BankProcessingFailedException){
                System.out.println("BankProcessingFailedException" + ((BankProcessingFailedException) ex).getMessage());
            }
            System.out.println(ex.getMessage() + " нужно вводить число > 0");
        } catch (InvalidPaymentCurrencyException ex) {
            System.out.println(ex.getMessage() + " вводите одно из: USD, EUR, JPY, CHF");
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() + " у вас параметр currency заполнен как null))"); //можно взять еще кейс когда currency null
        } catch (Exception ex){
            System.out.println(ex.getMessage() + " непонятная ошибка");//можно было еще добавить общий Exception для того чтобы избежать ошибки которую не обработали.
        }
    }
}
