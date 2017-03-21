/* Write a function reverseWords() that takes a string message 
   and reverses the order of the words in-place. Write a function 
   reverseWords() that takes a string message and reverses the 
   order of the words in-place
 */

public class ReverseWords {

    public static void reverseWord(char[] array, int beg, int end) {
	if (beg >= end) return;
	int len = end - beg + 1;
	for (int i = 0; i <= (len - 2) / 2; i++) {
	    char c = array[beg + i];
	    array[beg + i] = array[end - i];
	    array[end - i] = c;
	}
    }
    
    public static void reverseWords(char[] array) {
        reverseWord(array, 0, array.length - 1);
	System.out.println(array);
	int beg, end;
	beg = 0;
	end = 0;
	while (beg < array.length) {
	    while (end < array.length && array[end] != ' ') end++;
	    reverseWord(array, beg, end - 1);
	    end++;
	    beg = end;
	}
    }

    public static void main(String[] args) {
	String str = "behdad salimi is real hero";
	char[] arr = str.toCharArray();
	System.out.println(arr);
	reverseWords(arr);
	System.out.println(new String(arr));
    }
}
