package Task_1;

import java.io.*;
import java.util.Random;

public class WordList {
    private final Random rand = new Random();

    protected final String[] arrWords = new String[135];
    protected int hp = 10;

    // ВВЕДИТЕ ВАШ ПУТЬ
    protected String FILENAME = "D:\\Java projects\\Test tasks\\Task_1\\words.txt";

    protected void fillWords() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILENAME);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String line;
            for(int i = 0; i < arrWords.length && (line = bufferedReader.readLine()) != null; i++) {
                arrWords[i] = line;
            }
        } catch(IOException e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }

    protected String createWord() {
        return arrWords[rand.nextInt(arrWords.length)];
    }

    protected void displayAnswer(String randomWord, char[] arrWordLetters) {
        for(int i = 0; i < randomWord.length(); i++) {
            System.out.print(arrWordLetters[i] + " ");
        }
        System.out.println("\t" + hp + " HP");
        for(int i = 0; i < randomWord.length(); i++) {
            System.out.print("_ ");
        }
    }
}
