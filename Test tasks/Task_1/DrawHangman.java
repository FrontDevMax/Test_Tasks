package Task_1;

public class DrawHangman extends WordList {
    protected final String[] HUMAN = {
            "\n\n\n\n\n\n",
            "  ┏\n  |\n  |\n  |\n  |\n  |\n  |",
            "  ┏\n  |\n  |\n  |\n  |\n  |\n__|__",
            "  ┏------\n  |\n  |\n  |\n  |\n  |\n__|__",
            "  ┏------┓\n  |      |\n  |\n  |\n  |\n  |\n__|__",
            "  ┏------┓\n  |      |\n  |      O\n  |\n  |\n  |\n__|__",
            "  ┏------┓\n  |      |\n  |      O\n  |      |\n  |      |\n  |\n__|__",
            "  ┏------┓\n  |      |\n  |      O\n  |      |\n  |      |\n  |     /  \n__|__",
            "  ┏------┓\n  |      |\n  |      O\n  |      |\n  |      |\n  |     / \\ \n__|__",
            "  ┏------┓\n  |      |\n  |      O\n  |     /|\n  |      |\n  |     / \\ \n__|__",
            "  ┏------┓\n  |      |\n  |      O\n  |     /|\\\n  |      |\n  |     / \\ \n__|__",
    };

    protected void displayHuman(int countWrong) {
        System.out.println(HUMAN[countWrong] + "\n");
    }
}
