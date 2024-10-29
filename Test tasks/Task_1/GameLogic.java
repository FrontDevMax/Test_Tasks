package Task_1;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GameLogic extends DrawHangman {
    private final Scanner sc = new Scanner(System.in);

    private int countWrongs = 0;
    private String randomWord;
    private int countLetters;
    private char userLetter = ' ';
    private char[] arrWordLetters;
    private char[] arrUserLetters = new char[100000];

    private final String SPECIAL_CHARS = ".*[!@#$%^&*()_+-={}\\[\\]|;':\\\",./<>?].*";
    private final String RUSSIAN_LETTERS = ".*[абвгдеёжзийклмнопрстуфхцчшщъыьэюя].*";

    public void displayGame() throws IOException {
        System.out.println("\nИГРА \"ВИСЕЛИЦА\"");
        fillWords();
        randomWord = createWord();
        arrWordLetters = new char[randomWord.length()];
        countLetters = randomWord.length();
        while(countLetters != 0 && countWrongs < 10) {
            displayHuman(countWrongs);
            displayAnswer(randomWord, arrWordLetters);
            typeAnswer();
            checkAnswer();
        }
        checkWin(countWrongs);
        continueGame();
    }

    private void typeAnswer() {
        String userAnswer;
        System.out.print("\n\nВведите любую букву: ");
        userAnswer = sc.nextLine().toLowerCase();
        System.out.println();
        if (userAnswer.length() > 1 || Pattern.matches(SPECIAL_CHARS, userAnswer) || userAnswer.isEmpty()) {
            System.out.println("Вы ввели слово или предложение, или ничего!");
        } else {
            userLetter = userAnswer.charAt(0);
        }
    }

    private void checkAnswer() {
        boolean isFind = false;
        try {
            if (userLetter == ' ') {
                isFind = true;
            } else if(Pattern.matches(RUSSIAN_LETTERS, Character.toString(userLetter))) {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (arrUserLetters[userLetter] == 0) {
                        if (userLetter == randomWord.charAt(i)) {
                            arrWordLetters[i] = userLetter;
                            countLetters--;
                            isFind = true;
                        }
                    } else {
                        System.out.println("Вы ввели эту букву недавно! Введите другую!");
                        isFind = true;
                        break;
                    }
                }
            } else {
                System.out.println("Вы ввели не русские буквы!");
                isFind = true;
            }
        } catch(Exception ex) {
            System.out.println("Вы неправильно ввели что-то!");
        }
        if (!isFind) {
            countWrongs++;
            hp--;
        }
        arrUserLetters[userLetter]++;
        userLetter = ' ';
    }

    private void checkWin(int countWrong) {
        displayHuman(countWrong);
        displayAnswer(randomWord, arrWordLetters);
        System.out.println("\n");
        String result = countWrong < 10 ? "Вы угадали слово!" : "Вы не угадали слово! Верный ответ был " + randomWord;
        System.out.println(result);
    }

    private void continueGame() throws IOException {
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
            clearGame();
            displayGame();
        }
    }

    private void clearGame() {
        arrUserLetters = new char[100000];
        countWrongs = 0;
        hp = 10;
    }

}
