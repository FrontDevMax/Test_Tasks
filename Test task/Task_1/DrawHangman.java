package Task_1;

public class DrawHangman extends WordList {
    protected final String[] human = {
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
        System.out.println(human[countWrong] + "\n");
    }
}
