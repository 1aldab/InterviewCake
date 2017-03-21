public class MatchingParens {

    public static int getMatchingParens(String str, int pointer) {
	if (str.charAt(pointer) != '(') return -1;
	int counter = 1;
	while (counter > 0) {
	    pointer++;
	    if (pointer < str.length()) {
		if (str.charAt(pointer) == '(') counter++;
		if (str.charAt(pointer) == ')') counter--;
	    } else
		break;
	}
	if (counter == 0) return pointer;
	return -1;
    }

    public static void main(String[] args) {
	String str = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
	System.out.println(str);
	System.out.println("Matching parens of " + 10 + " is " + getMatchingParens(str, 10));
    }
}
