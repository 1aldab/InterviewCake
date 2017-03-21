/* Given the array of IDs, which contains many duplicate 
   integers and one unique integer, find the unique integer.
*/

import java.util.*;

public class FindUniqueUsingList {

    static List<Long> seen = new ArrayList<Long>();

    public static void insert(int id) {
	int index = id / 64;
	int bitidx = id % 64;
	long bitmap = 1L << bitidx;
	if (seen.size() > index) {
	    bitmap |= seen.get(index);
	    seen.remove(index);
	    seen.add(index, bitmap);
	}
	else {
	    for (int i = seen.size(); i < index; i++)
		seen.add(i, 0L);
	    seen.add(index, bitmap);
	}
    }

    public static void delete(int id) {
	int index = id / 64;
	if (index > seen.size()) return;
	int bitidx = id % 64;
	long bitmap = ~(1L << bitidx);
	bitmap &= seen.get(index);
	seen.remove(index);
	seen.add(index, bitmap);
    }

    public static int findUnique() {
	for (int index = 0; index < seen.size(); index++) {
	    long bitmap = seen.get(index);
	    if (bitmap != 0) {
		int bitidx = 0;
		while ((bitmap & 1L) == 0) {
		    bitidx++;
		    bitmap >>= 1;
		}
		return 64 * index + bitidx;
	    }
	}
	return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
	insert(130);
        insert(149);
	delete(130);
	insert(490);
	delete(149);
	insert(892);
	insert(729);
	delete(892);
	delete(128);
	delete(490);
	System.out.println("Unique ID is " + findUnique());
    }

}
