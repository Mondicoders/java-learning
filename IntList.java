import java.util.Arrays;

public class IntList {
    private int[] arr = new int[2];
    private int size;

    public void add(int value) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = value;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        return arr[index];
    }
}
