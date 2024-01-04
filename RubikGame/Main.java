public class Main {


    public static void main(String[] args) {
        RubikCube cube = new RubikCube();
        System.out.println(cube);
        cube.leftTurn(true);
        System.out.println(cube);
    }
}