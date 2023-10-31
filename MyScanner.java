import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.NoSuchElementException;
import java.io.Reader;

public class MyScanner implements AutoCloseable {
	private enum LineMode {
        CR, // \r
        LF, // \n
        CRLF // \r\n
    }
    private final Reader reader;
    private LineMode mode;
    private static final int BUFFER_SIZE = 1024;
    private final char[] buffer = new char[BUFFER_SIZE];
    private int position;
    private int length;
    private String curLine;
    private String curToken;
    private boolean isPrevCRLF;
    private boolean isLineReaded;
    private boolean isTokenReaded;
    private final StringBuilder builder = new StringBuilder();

    public MyScanner(Reader reader) { // ctor
        this.reader = reader;
        getSystemLineSeparator();
    }

    public MyScanner(InputStream stream) { // ctor
        this.reader = new InputStreamReader(stream);
        getSystemLineSeparator();
    }

    public MyScanner(String source) { // ctor
        this.reader = new StringReader(source);
        getSystemLineSeparator();
    }

    private void getSystemLineSeparator() { // get line seprator in system
        if (System.lineSeparator() == "\n") {
            mode = LineMode.LF;
        } else if (System.lineSeparator() == "\r") {
            mode = LineMode.CR;
        } else {
            mode = LineMode.CRLF;
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }

    private boolean updateBuffer() throws IOException {
        if (position >= length) {
            length = reader.read(buffer);
            position = 0;
            return true;
        }
        return false;
    }

    private static boolean isSeparator(char ch) {
        int type = Character.getType(ch);
        return type == Character.SPACE_SEPARATOR || type == Character.CONTROL
            || type == Character.PARAGRAPH_SEPARATOR || type == Character.LINE_SEPARATOR;
    }


    private String nextLineToken() throws IOException {   
        builder.setLength(0);
        while (position < length || updateBuffer()) {
            char ch = buffer[position];
            position++;
            if (mode == LineMode.LF && ch != '\n'
                || mode == LineMode.CR && ch != '\r'
                || mode == LineMode.CRLF && ch != '\r' && ch != '\n') {
                    builder.append(ch);
                } else if (builder.isEmpty()) {
                    if (mode == LineMode.CRLF) {
                        if (isPrevCRLF) {
                            isPrevCRLF = false;
                            isLineReaded = true;
                            return "";
                        }
                        isPrevCRLF = true;
                    } else {
                        isLineReaded = true;
                        return "";
                    }
                } else {
                    break;
                }
        }
        if (builder.isEmpty()) {
            return null;
        }
        isLineReaded = true;
        return builder.toString();
    }

    public boolean hasNextLine() throws IOException {
        curLine = nextLineToken();
        return curLine != null;
    }

    public String nextLine() throws IOException {
        if (!isLineReaded) {
            if (!hasNextLine()) {
                throw new NoSuchElementException("Can't read line.");
            }
        }
        return curLine;
    }

    private String nextToken() throws IOException {
        builder.setLength(0);
        while (position < length || updateBuffer()) {
            char ch = buffer[position++];
            if (!isSeparator(ch)) {
                builder.append(ch);
            } else if (builder.isEmpty()) {
                break;
            }
        }
        if (builder.isEmpty()) {
            return null;
        }
        isTokenReaded = true;
        return builder.toString();
    }

    public String next() throws IOException {
        if (!isTokenReaded && !hasNext()) {
            throw new NoSuchElementException("Can't read.");
        }
        isTokenReaded = false;
        return curToken;
    }

    public boolean hasNext() throws IOException {
        curToken = nextToken();
        return curToken != null;
    }

    public int nextInt() throws IOException {
        if (!isTokenReaded && !hasNextInt()) {
            throw new NoSuchElementException("Can't read int");
        }
        isTokenReaded = false;
        return Integer.parseInt(curToken);
    }

    public boolean hasNextInt() throws IOException {
        curToken = nextToken();
        if (curToken == null) {
            return false;
        }
        for (char ch : curToken.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
