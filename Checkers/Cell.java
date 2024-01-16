public enum Cell {
  WHITE("W"),
  BLACK("B"),
  EMPTY(".");

  private final String value;

  Cell(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
