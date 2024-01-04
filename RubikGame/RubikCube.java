public class RubikCube {
    private Color[][] up = new Color[3][3];
    private Color[][] down = new Color[3][3];
    private Color[][] left = new Color[3][3];
    private Color[][] right = new Color[3][3];
    private Color[][] back = new Color[3][3];
    private Color[][] front = new Color[3][3];

    public RubikCube() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                up[i][j] = Color.WHITE;
                down[i][j] = Color.YELLOW;
                front[i][j] = Color.BLUE;
                back[i][j] = Color.GREEN;
                left[i][j] = Color.RED;
                right[i][j] = Color.ORANGE;
            }
        }
    }

    private int getTimes(String command, int pos) {
        if (pos < command.length() && Character.isDigit(command.charAt(pos))) {
            return command.charAt(pos) - '0';
        }
        return 1;
    }

    public void parse(String command) {
        char side = command.charAt(0);
        boolean clockwise = true;
        int times = 1;
        if (command.length() > 1 && command.charAt(1) == '\'') {
            clockwise = false;
            times = getTimes(command, 2);
        } else {
            times = getTimes(command, 1);
        }
        switch (side) {
            case 'L':
                for (int t = 0; t < times; t++) leftTurn(clockwise);
                break;
        }
    }

    private Color[][] rotateSide(Color[][] data) {
        Color[][] tmp = new Color[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    tmp[i][j] = left[j][i];
                } else if (i == 2) {
                    tmp[i][j] = left[2 - j][i];
                } else if (j == 0) {
                    tmp[i][j] = left[2][i];
                } else if (j == 2) {
                    tmp[i][j] = left[i][2];
                } else {
                    tmp[i][j] = left[i][j];
                }
            }
        }
        return tmp;
    }

    public void leftTurn(boolean clockwise) {
        left = rotateSide(left);
        Color[] row = new Color[3];
        for (int i = 0; i < 3; i++) {
            row[i] = up[i][0];
            up[i][0] = back[2 - i][0];
        }
        for (int i = 0; i < 3; i++) {
            Color c = front[i][0];
            front[i][0] = row[i];
            row[i] = c;
        }
        for (int i = 0; i < 3; i++) {
            Color c = down[i][0];
            down[i][0] = row[i];
            row[i] = c;
        }
        for (int i = 0; i < 3; i++) {
            back[i][0] = row[i];
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        printOneSight(builder, up);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(back[i][j]);
            }
            for (int j = 0; j < 3; j++) {
                builder.append(left[i][j]);
            }
            for (int j = 0; j < 3; j++) {
                builder.append(front[i][j]);
            }
            for (int j = 0; j < 3; j++) {
                builder.append(right[i][j]);
            }
            builder.append(System.lineSeparator());
        }
        printOneSight(builder, down);
        return builder.toString();
    }

    private void printOneSight(StringBuilder builder, Color[][] down) {
        for (int i = 0; i < 3; i++) {
            builder.append(" ".repeat(3));
            for (int j = 0; j < 3; j++) {
                builder.append(down[i][j]);
            }
            builder.append(System.lineSeparator());
        }
    }
}
