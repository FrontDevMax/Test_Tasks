package Task_3;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GeneratePassword {
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-={}[]|;':\",./<>?";

    public static void main(String[] args) {
        displayPassword();
    }

    private static void displayPassword() {
        int userLength = typeLengthPassword();
        System.out.println(generatePassword(userLength));
        continueCurrency();
    }

    private static int typeLengthPassword() {
        System.out.println("\nГЕНЕРАТОР ПАРОЛЕЙ\n");
        int userLength = 0;
        boolean isFlag = true;
        do {
            try {
                System.out.print("Введите длину пароля(от 8 до 12 символов): ");
                userLength = sc.nextInt();
                if (userLength <= 12 && userLength >= 8) {
                    System.out.println("Вот ваш безопасный пароль!");
                    isFlag = false;
                } else {
                    System.out.println("Вы должны были ввести от 8 до 12 символов!");
                }
            } catch(Exception ex) {
                System.out.println("Вы неправильно ввели что-то!");
            }
        } while(isFlag);
        return userLength;
    }

    private static String generatePassword(int userLength) {
        String regex = ".*[a-z].*[A-Z].*[0-9].*[!@#$%^&*()_+-={}\\[\\]|;':\\\",./<>?].*";
        StringBuilder password = new StringBuilder();
        String charFill = "";
        if(Pattern.matches(".*[a-z].*", regex)) charFill += LOWER_CASE;
        if(Pattern.matches(".*[A-Z].*", regex)) charFill += UPPER_CASE;
        if(Pattern.matches(".*[0-9].*", regex)) charFill += NUMBERS;
        if(Pattern.matches(".*[!@#$%^&*()_+-={}\\[\\]|;':\\\",./<>?].*", regex)) charFill += SPECIAL_CHARS;
        for(int i = 0; i < userLength; i++) {
            password.append(charFill.charAt(rand.nextInt(charFill.length())));
        }
        return password.toString();
    }

    private static void continueCurrency() {
        boolean isAnswer = false;
        char userChoose = 0;
        while(!isAnswer) {
            System.out.print("\nПродолжим генерировать?(д/н): ");
            userChoose = sc.next().toLowerCase().charAt(0);
            if(userChoose != 'д' && userChoose != 'н') {
                System.out.println("Вы ввели не то!");
            } else {
                isAnswer = true;
            }
        }

        if(userChoose == 'д') {
            displayPassword();
        }
    }
}
