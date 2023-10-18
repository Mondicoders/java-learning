public class SumDoubleSpace {
	public static void main (String args[]) {
		double sum = 0;
        final StringBuilder builder = new StringBuilder();
		for (String arg : args) { 
			for (char ch : arg.toCharArray()) { 
                if (!Character.isWhitespace(ch) && Character.getType(ch) != Character.SPACE_SEPARATOR) {
                    builder.append(ch);
                } else {
                    if (!builder.isEmpty()) {
                        sum += Double.parseDouble(builder.toString());
                        builder.setLength(0);
                    }
                }
            }
            if (!builder.isEmpty()) {
                sum += Double.parseDouble(builder.toString());
                builder.setLength(0);
            }					
		}
		System.out.println(sum);
	}
}                       