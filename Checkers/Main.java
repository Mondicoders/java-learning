import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(new Board(), new HumanPlayer(scanner, System.out), new HumanPlayer(scanner, System.out), System.out);
        game.play(true);
    }
}
