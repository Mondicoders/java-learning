public class Board implements Position {
  private final int SIZE = 8;
  private final Cell[][] data = new Cell[SIZE][SIZE];
  private Cell turn = Cell.WHITE;

  public Board() {
    for (int i = 0; i < SIZE / 2 - 1; i++) {
      for (int x = 1; x < SIZE; x += 2) {
        data[i][i % 2 == 0 ? x - 1 : x] = Cell.WHITE;
        data[i][i % 2 == 0 ? x : x - 1] = Cell.EMPTY;
        data[SIZE - i - 1][i % 2 == 0 ? x : x - 1] = Cell.BLACK;
        data[SIZE - i - 1][i % 2 == 0 ? x - 1 : x] = Cell.EMPTY;
      }
    }
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < SIZE; x++) {
        data[SIZE / 2 + i - 1][x] = Cell.EMPTY;
      }
    }
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    for (int y = 0; y < SIZE; y++) {
      for (int x = 0; x  < SIZE; x++) {
        builder.append(data[y][x]).append(" ");
      }
      builder.append(System.lineSeparator());
    }
    return builder.toString();
  }

  public GameResult makeMove(final Move move) {
    data[move.getY()][move.getX()] = move.getTurn();
    data[move.getChecker().getY()][move.getChecker().getX()] = Cell.EMPTY;

    int endX = move.getX();
    int endY = move.getY();
    int startX = move.getChecker().getX();
    int startY = move.getChecker().getY();
    int delta = move.getTurn() == Cell.WHITE ? 1 : -1;
    if (startY + 2 * delta == endY) {
      data[startY + delta][(startX + endX) / 2] = Cell.EMPTY;
    }

    if (checkWin()) {
      return GameResult.WIN;
    }

    if (checkDraw()) {
      return GameResult.DRAW;
    }

    turn = turn == Cell.WHITE ? Cell.BLACK : Cell.WHITE;
    return GameResult.UNKNOWN;
  }


  private boolean checkWin() {
    final Cell target = turn == Cell.WHITE ? Cell.BLACK  : Cell.WHITE;
    for (int y = 0; y < SIZE; y++) {
      for (int x = 0; x < SIZE; x++) {
        if (data[y][x] == target) {
          return false;
        }
      }
    }
    return true;
  }

  private int getCheckersCount(Cell target) {
    int count = 0;
    for (int y = 0; y < SIZE; y++) {
      for (int x = 0; x < SIZE; x++) {
        if (data[y][x] == target) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean checkDraw() {
    int countWhite = 0, countBlack = 0;
    for (int x = 0; x < SIZE; x++) {
      if (data[0][x] == Cell.BLACK) {
        countBlack++;
      }
      if (data[SIZE - 1][x] == Cell.WHITE) {
        countWhite++;
      }
    }
    return countBlack == getCheckersCount(Cell.BLACK) ||
      countWhite == getCheckersCount(Cell.WHITE);
  }

  @Override
  public boolean isValidMove(final Move move) {
    int endX = move.getX();
    int endY = move.getY();
    int startX = move.getChecker().getX();
    int startY = move.getChecker().getY();
    int delta = move.getTurn() == Cell.WHITE ? 1 : -1;
    final Cell target = move.getTurn() == Cell.WHITE ? Cell.BLACK : Cell.WHITE;
    System.out.println((endY -  delta) + " " + startY + " " + data[startY][startX]
     + move.getTurn() + data[endY][endX]);
    return 0 <= endY && endY < SIZE && 0 <= endX && endX  < SIZE &&
    0 <= startY && startY < SIZE &&
    0 <= startX && startX < SIZE && 
    data[startY][startX] == move.getTurn() && 
    data[endY][endX] == Cell.EMPTY &&
    ((endY - delta == startY && Math.abs(endX - startX) == 1) ||
    (endY - 2 * delta == startY && Math.abs(endX - startX) == 2 &&
    (data[startY + delta][(endX + startX)/2] == target)));
  }

  public Cell getTurn() {
    return turn;
  }

  public Position getPosition() {
    return this;
  }
}
