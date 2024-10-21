package Task_1;

import java.io.IOException;
import java.util.Scanner;

public class GameLogic extends DrawHangman {
    private final Scanner sc = new Scanner(System.in);

    private int countWrongs = 0;
    private String randomWord;
    private int countLetters;
    private char userLetters;
    private char[] arrWordLetters;

    private void startGame() {
        System.out.print("\n\nВведите любую букву: ");
        userLetters = sc.next().toLowerCase().charAt(0);
        System.out.println();
    }

    public void displayGame() throws IOException {
        System.out.println("\nИГРА \"ВИСЕЛИЦА\"");
        fillWords();
        randomWord = createWord();
        arrWordLetters = new char[randomWord.length()];
        countLetters = randomWord.length();
        while(countLetters != 0 && countWrongs < 10) {
            displayHuman(countWrongs);
            displayAnswer(randomWord, arrWordLetters);
            startGame();
            checkAnswer();
        }
        checkWin(countWrongs);
        continueGame();
    }

    private void checkAnswer() {
        boolean isFind = false;
        for(int i = 0; i < randomWord.length(); i++) {
            if((userLetters == randomWord.charAt(i))) {
                arrWordLetters[i] = userLetters;
                countLetters--;
                isFind = true;
            }
        }
        if(!isFind) {
            countWrongs++;
            hp--;
        }
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
        while(!isAnswer) {
            System.out.print("\nПродолжим игру?(д/н): ");
            userLetters = sc.next().toLowerCase().charAt(0);
            if(userLetters != 'д' && userLetters != 'н') {
                System.out.println("Вы ввели не то!");
            } else {
                isAnswer = true;
            }
        }

        if(userLetters == 'д') {
            clearGame();
            displayGame();
        }
    }

    private void clearGame() {
        countWrongs = 0;
        hp = 10;
    }

}
