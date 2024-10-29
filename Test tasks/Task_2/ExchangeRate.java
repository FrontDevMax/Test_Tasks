package Task_2;

import javax.security.auth.callback.TextInputCallback;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExchangeRate {
    private final static Scanner sc = new Scanner(System.in);

    private final static float eurInUsd = 1.09f;
    private final static float cnyInUsd = 0.140825f;
    private final static float kztInUsd = 0.002071f;
    private final static float bynInUsd = 0.301941f;
    private final static float rubInUsd = 0.010372f;

    private final static float usdInEur = 0.92018f;
    private final static float usdInCny = 7.1f;
    private final static float usdInKzt = 482.92f;
    private final static float usdInByn = 3.31f;
    private final static float usdInRub = 96.42f;

    private static int userCurrencyInUsd = 0, userUsdInCurrency = 0;
    private final static String[] arrCurrency = {"1. Евро", "2. Китайский юань", "3. Казахский тенге", "4. Белорусский рубль", "5. Российский рубль"};
    private final static float[] arrCurrencyInUsd = {eurInUsd, cnyInUsd, kztInUsd, bynInUsd, rubInUsd};
    private final static float[] arrUsdInCurrency = {usdInEur, usdInCny, usdInKzt, usdInByn, usdInRub};

    public static void main(String[] args) {
        displayProgram();
    }

    private static void displayProgram() {
        System.out.println("\nКОНВЕРТЕР КУРС ВАЛЮТЫ\n");
        float moneyUser = typeMoney();
        if(moneyUser != 0.0) {
            typeCurrency();
            System.out.println(converterCurrency(moneyUser));
            continueCurrency();
        }
    }

    private static float typeMoney() {
        float result = 0;
        try {
            System.out.print("Сколько денег ты хочешь перевести?(без валюты): ");
            result = sc.nextFloat();
        } catch(InputMismatchException ex) {
            System.out.println("Без валюты! Запустите снова и введите еще раз!.");
            return 0;
        }
        return result;
    }

    private static void typeCurrency() {
        boolean isAnswer = true;
        while(isAnswer) {
            displayCurrency();
            System.out.print("\nИз какой валюты вы хотите перевести? Выберите 1-5: ");
            userCurrencyInUsd = sc.nextInt();
            if (userCurrencyInUsd <= 5 && userCurrencyInUsd >= 1) {
                isAnswer = false;
            } else {
                System.out.println("Вы ввели больше 5 или меньше нуля!");
            }
        }
        isAnswer = true;
        while(isAnswer) {
            displayCurrency();
            System.out.print("\nВ какую валюту вы хотите перевести? Выберите 1-5: ");
            userUsdInCurrency = sc.nextInt();
            System.out.println();
            if(userUsdInCurrency <= 5 && userUsdInCurrency >= 1) {
                isAnswer = false;
            } else {
                System.out.println("Вы ввели больше 5 или меньше нуля!");
            }
        }
    }

    private static void displayCurrency() {
        System.out.println();
        for(int i = 0; i < arrCurrency.length; i++) {
            System.out.println(arrCurrency[i]);
        }
    }

    private static float converterCurrency(float moneyUser) {
        return moneyUser * arrCurrencyInUsd[userCurrencyInUsd - 1] * arrUsdInCurrency[userUsdInCurrency - 1];
    }

    private static void continueCurrency() {
        boolean isAnswer = false;
        String userChoose = "";
        while(!isAnswer) {
            System.out.print("\nПродолжим игру?(да/нет): ");
            userChoose = sc.next();
            if(userChoose.equalsIgnoreCase("да") || userChoose.equalsIgnoreCase("нет")) {
                isAnswer = true;
            } else {
                System.out.println("Вы ввели не то!");
            }
        }

        if(userChoose.equalsIgnoreCase("да")) {
            displayProgram();
        }
    }
}