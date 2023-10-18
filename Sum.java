public class Sum {
    public static void main(String[] args) {
        int sum = 0;
        final StringBuilder builder = new StringBuilder();
        for (String arg : args) { // foreach
            for (char ch : arg.toCharArray()) { 
                if (!Character.isWhitespace(ch)) {
                    builder.append(ch);
                } else {
                    if (!builder.isEmpty()) {
                        sum += Integer.parseInt(builder.toString());
                        builder.setLength(0);
                    }
                }
            }
            if (!builder.isEmpty()) {
                sum += Integer.parseInt(builder.toString());
                builder.setLength(0);
            }
        }
        System.out.println(sum);
    }   
}
