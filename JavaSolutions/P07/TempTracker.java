import java.util.*;

public class TempTracker {
    int min = Integer.MAX_VALUE;
    int max = -1;
    double mean = 0;
    int mode = -1;
    int modeCount = 0;
    int tempCount = 0;
    
    HashMap<Integer, Integer> temps = new HashMap<Integer,Integer>();

    public void insert(int t) {
	int currCount = temps.get(t);
	temps.put(t, currCount + 1);
	if (this.min > t) this.min = t;
	if (this.max < t) this.max = t;
	this.mean = (this.mean * tempCount + t) / (tempCount + 1);
	if (currCount > modeCount) {
	    this.mode = t;
	    this.modeCount = currCount;
	}
	this.tempCount++;
    }

    public int getMin() {
	return this.min;
    }

    public int getMax() {
	return this.max;
    }

    public int getMean() {
	return this.mean;
    }

    public int getMode() {
	return this.mode;
    }
}
