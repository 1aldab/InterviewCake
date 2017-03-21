/* Write a function condenseMeetingTimes() that takes a list of meeting time 
   ranges and returns a list of condensed ranges. Do not assume the meetings
   are in order. The meeting times are coming from multiple teams.
   
   Write a solution that's efficient even when we can't put a nice upper bound 
   on the numbers representing our time ranges. Here we've simplified our times 
   down to the number of 30-minute slots past 9:00 am. But we want the function 
   to work even for very large numbers, like Unix timestamps. In any case, the 
   spirit of the challenge is to merge meetings where startTime and endTime 
   don't have an upper bound.
 */

import java.util.*;

public class HiCal {

    private static class CalTime implements Comparable<CalTime> {
	public int beg;
	public int end;

	public CalTime(int b, int e) {
	    this.beg = b;
	    this.end = e;
	}

	public int compareTo(CalTime c) {
	    return this.beg - c.beg;
	}

	public String toString() {
	    return String.format("(%d,%d)", this.beg, this.end);
	}
    }

    public static ArrayList<CalTime> merge(CalTime[] times) {
	Arrays.sort(times);  // nlogn time

	ArrayList<CalTime> merged = new ArrayList<CalTime>();
	for (int i = 0; i < times.length; i++) {
	    int b = times[i].beg;
	    int e = times[i].end;
	    while (++i < times.length && times[i].beg >= b && times[i].beg <= e) {
		if (e < times[i].end) e = times[i].end;
	    }
	    merged.add(new CalTime(b,e));
	    i--;
	}

	return merged;
    }

    public static void test(CalTime[] times) {
	ArrayList<CalTime> merged = merge(times);
	System.out.println("Input Times:  " + Arrays.toString(times));
	System.out.print("Merged Times: [");
	for (CalTime c : merged) System.out.print(c + ", ");
	System.out.println("]");
	System.out.println("_______________________________________");
    }

    public static void main(String[] args) {
	CalTime[] times1 = new CalTime[] {new CalTime(4,8), new CalTime(0,1), new CalTime(6,7),
					  new CalTime(10,12), new CalTime(3,5), new CalTime(9,10)};
	CalTime[] times2 = new CalTime[] {new CalTime(2,6), new CalTime(7,9), new CalTime(3,5),
					  new CalTime(1,10), new CalTime(5,6), new CalTime(5,9)};
	test(times1);
	test(times2);
    }
    
}
