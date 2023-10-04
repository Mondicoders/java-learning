import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Arr {
    /*
    [
    [1, 2],
    [3]
    ]
     */

    static class User {
        private String name;
        private int age;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        int len = list.size();
//        System.out.println(list);
//        IntList list = new IntList();
//        for (int i = 0; i < 10; i++) {
//            list.add(i * 2);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.printf("%d, ", list.get(i));
//        }
        Scanner scanner = new Scanner(System.in);
//        if (scanner.hasNextInt()) {
//            System.out.println(scanner.nextInt());
//        } else {
//            System.out.println("Not Integer");
//        }
//        long a = Long.MAX_VALUE - 1;
//        int b = (int)a; // overflow
//        System.out.println(b);
//        IntList list = new IntList();
//        while (scanner.hasNextInt()) {
//            list.add(scanner.nextInt());
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.printf("%d ", list.get(i));
//        }
        List<IntList> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            IntList l = new IntList();
            while (lineScanner.hasNextInt()) {
                l.add(lineScanner.nextInt());
            }
            list.add(l);
        }

        // foreach
        for (IntList intList : list) {
            for (int j = 0; j < intList.size(); j++) {
                System.out.print(intList.get(j) + " ");
            }
            System.out.println();
        }
    }
}