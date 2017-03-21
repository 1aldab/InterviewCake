import java.util.*;

public class BracketValidator {

    public static char match(char c) {
	switch (c) {
	case '(':
	    return ')';
	case '[':
	    return ']';
	case '{':
	    return '}';
	default:
	    return '\0';
	}
    }

    public static boolean isValid(String brackets) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : brackets.toCharArray()) {
	    if (c == '[' || c == '(' || c == '{')
		stack.push(c);
	    else if (c == ']' || c == ')' || c == '}') {
		if (c != match(stack.pop()))
		    return false;
	    }	
	}
	return true;
    }

    public static void test(String s) {
	System.out.print(s);
	if (isValid(s)) System.out.println(" is valid");
	else System.out.println(" is invalid");
	System.out.println("_________________________");
    }
    
    public static void main(String[] args) {
	test("{([()()])[{(()())}]{[([]({}))]}}");
	test("{[(])}");
    }
}
