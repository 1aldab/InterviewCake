/* Write a function to reverse a string in-place. Since strings 
   in Java are immutable, first convert the string into an 
   array of characters, do the in-place reversal on that array, 
   and re-join that array into a string before returning it. 
   This isn't technically "in-place" and the array of characters 
   will cost O(n) additional space, but it's a reasonable 
   way to stay within the spirit of the challenge.
 */

public class ReverseString {

    public static String reverseStr(String str) {
	char[] strArr = str.toCharArray();
	int len = strArr.length;
	for (int i = 0; i <= (len - 2) / 2; i++) {
	    char temp = strArr[i];
	    strArr[i] = strArr[len - 1 - i];
	    strArr[len - 1 - i] = temp;
	}
	return new String(strArr);
    }

    public static void main(String[] args) {
	System.out.println(reverseStr("hello"));
	System.out.println(reverseStr("kcuf"));
	System.out.println(reverseStr(""));
	System.out.println(reverseStr("this is a test"));
    }
}
