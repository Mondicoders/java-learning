public class Move {
  private final int x;
  private final int y;
  private final Checker checker;
  private final Cell turn;

  public Move(int x, int y, Checker checker, Cell turn) {
    this.x = x;
    this.y = y;
    this.checker = checker;
    this.turn = turn;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Checker getChecker() {
    return checker;
  }

  public Cell getTurn() {
    return turn;
  }
}
