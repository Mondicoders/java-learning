import java.io.PrintStream;
import java.util.List;

public class Tourment {
    private static final int WIN_POINTS = 3;
    private static final int DRAW_POINTS = 1;
    private static final int LOOSE_POINTS = 0;

    private final List<Player> players;
    private final PrintStream outputStream;
    private final int[] points;

    public Tourment(final List<Player> players, final PrintStream outputStream) {
        this.players = players;
        this.outputStream = outputStream;
        this.points = new int[players.size()];
    }

    private void showStatistics() {
        outputStream.print("Players | ");
        for (int i = 0; i < points.length; i++) {
            outputStream.print((i + 1) + " ");
        }
        outputStream.println();
        outputStream.print("Points | ");
        for (int point : points) {
            outputStream.print(point + " ");
        }
        outputStream.println();
    }

    private void playGame(int no1, int no2) {
        outputStream.println("Player " + no1 + " plays with player " + no2);
        final int result = new Game(new Board(), players.get(no1), players.get(no2), outputStream).play(false);
        switch (result) {
            case 1 -> {
                outputStream.println("Player " + no1 + " won");
                points[no1] += WIN_POINTS;
            }
            case 2 -> {
                outputStream.println("Player " + no2 + " won");
                points[no2] += WIN_POINTS;
            }
            case 0 -> {
                outputStream.println("Draw");
                points[no1] += DRAW_POINTS;
                points[no2] += DRAW_POINTS;
            }
            default -> {
                throw new RuntimeException("Invalid game reuslt");
            }
        }
    }

    public void play() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                playGame(i, j);
            }
        }
    }
}