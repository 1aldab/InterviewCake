import java.util.*;

public class KnapSack {

    public static class Cake {
	int weight;
	int value;

	public Cake(int w, int v) {
	    this.weight = w;
	    this.value = v;
	}

	public String toString() {
	    return "(" + this.weight + "," + this.value + ")";
	}
    }

    public static int maxValue(Cake[] cakes, int cap, int k) {
	if (k < 0 || k == cakes.length) return 0;
	int maxProf = 0;
	for (int i = 0; i * cakes[k].weight <= cap; i++) {
	    int prevProf = maxValue(cakes, cap - i * cakes[k].weight, k - 1);
	    int currProf = prevProf + i * cakes[k].value;
	    if (currProf > maxProf) maxProf = currProf;
	}
	return maxProf;
    }

    public static int maxValueDP(Cake[] cakes, int cap, int k, int[][] book) {
	if (k < 0 || k == cakes.length) return 0;
	int maxProf = 0;
	for (int i = 0; i * cakes[k].weight <= cap; i++) {
	    int prevProf;
	    if (book[cap - i * cakes[k].weight][k - 1] > 0)
		prevProf = book[cap - i * cakes[k].weight][k - 1];
	    else
		prevProf = maxValue(cakes, cap - i * cakes[k].weight, k - 1);
	    int currProf = prevProf + i * cakes[k].value;
	    if (currProf > maxProf) maxProf = currProf;
	}
	book[cap][k] = maxProf;
	return maxProf;
    }

    public static void test(Cake[] cakes, int cap) {
	System.out.println("Cakes:    " + Arrays.toString(cakes));
	System.out.println("Capacity: " + cap);
	System.out.println("Profit:   " + maxValue(cakes, cap, cakes.length - 1));
	System.out.println("____________________________________");
    }

    public static void testDP(Cake[] cakes, int cap) {
	System.out.println("Cakes:    " + Arrays.toString(cakes));
	System.out.println("Capacity: " + cap);
	System.out.println("Profit:   " +
			   maxValueDP(cakes, cap, cakes.length - 1, new int[cap+1][cakes.length]));
	System.out.println("____________________________________");
    }

    public static void main(String[] args) {
	Cake[] cakes1 = {new Cake(12, 24), new Cake(7, 13), new Cake(11, 23),
			 new Cake(8, 15), new Cake(9, 16)};
	testDP(cakes1, 26);

	Cake[] cakes2 = {new Cake(23, 92), new Cake(31, 57), new Cake(29, 49),
			 new Cake(44, 68), new Cake(53, 60), new Cake(38, 43),
			 new Cake(63, 67), new Cake(85, 84), new Cake(89, 87),
			 new Cake(82, 72)};
	testDP(cakes2, 165);
    }
}
