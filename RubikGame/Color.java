public enum Color {
    WHITE("W"),
    YELLOW("Y"),
    BLUE("B"),
    GREEN("G"),
    RED("R"),
    ORANGE("O");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
