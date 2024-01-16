import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner;
    private final PrintStream outputStream;

    public HumanPlayer(Scanner scanner, PrintStream outputStream) {
        this.scanner = scanner;
        this.outputStream = outputStream;
    }

    private boolean checkCorrectInput() {
        if (!scanner.hasNextInt()) {
            if (scanner.hasNext()) {
                scanner.hasNext();
            }
            return false;
        }
        return true;
    }

    @Override
    public Move makeMove(final Position position, final Cell turn) {
        outputStream.println("Enter move for " + turn);
        int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
        Move move;
        while (true) {
            if (checkCorrectInput()) {
                startRow = scanner.nextInt() - 1;
                if (checkCorrectInput()) {
                    startCol = scanner.nextInt() - 1;
                }
            }
            if (startCol != -1 && checkCorrectInput()) {
                endRow = scanner.nextInt() - 1;
                if (checkCorrectInput()) {
                    endCol = scanner.nextInt() - 1;
                }
            }
            move = new Move(endRow, endCol, new Checker(startRow, startCol), turn);
            if (position.isValidMove(move)) {
                break;
            }
            outputStream.println("Incorrect input. Try again");
            startRow = startCol = endRow = endCol = -1;
        }
        return move;
    }
}