package currencyconverter;

import java.util.Scanner;

public class CurrencyConverter {

    public static final double USD_TO_EUR = 0.93;
    public static final double USD_TO_GBP = 0.81;
    public static final double USD_TO_JPY = 144.5;
    public static final double USD_TO_RUB = 96.7;

    public static double toUSD(double amount, String currency) {
        return switch (currency.toUpperCase()) {
            case "USD" -> amount;
            case "EUR" -> amount / USD_TO_EUR;
            case "GBP" -> amount / USD_TO_GBP;
            case "JPY" -> amount / USD_TO_JPY;
            case "RUB" -> amount / USD_TO_RUB;
            default -> -1;
        };
    }

    public static void fromUSD(double usdAmount) {
        double eur = usdAmount * USD_TO_EUR;
        double gbp = usdAmount * USD_TO_GBP;
        double jpy = usdAmount * USD_TO_JPY;
        double rub = usdAmount * USD_TO_RUB;

        System.out.printf("USD: %.2f\n", usdAmount);
        System.out.printf("EUR: %.2f\n", eur);
        System.out.printf("GBP: %.2f\n", gbp);
        System.out.printf("JPY: %.2f\n", jpy);
        System.out.printf("RUB: %.2f\n", rub);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные валюты: USD, EUR, GBP, JPY, RUB");
        System.out.print("Введите валюту, из которой хотите конвертировать: ");
        String currency = scanner.nextLine();

        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();

        double usdAmount = toUSD(amount, currency);
        if (usdAmount < 0) {
            System.out.println("Неизвестная валюта!");
            return;
        }

        System.out.println("\nСумма в других валютах:");
        fromUSD(usdAmount);
    }
}