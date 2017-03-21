/* Write a function that takes: (1) an array of unsortedScores and 
   (2) the highestPossibleScore in the game and returns a sorted 
   array of scores in less than O(n\lg{n})O(nlgn) time.
 */

import java.util.*;

public class FastScoreSorter {

    public static void sortScores(int[] scores, int maxScore) {
	int size = scores.length;
	int[] scoreCounts = new int[maxScore + 1];
	for (int i : scores) {
	    scoreCounts[i]++;
	}
	int ptr = maxScore;
	for (int i = 0; i < size; i++) {
	    while(scoreCounts[ptr] == 0) ptr--;
	    scores[i] = ptr;
	    scoreCounts[ptr]--;
	}
    }

    public static void main(String[] args) {
	int[] scores = {125, 1100, 20, 5000, 1, 0, 125, 0, 1, 99999, 1, 20};
	System.out.println(Arrays.toString(scores));
	sortScores(scores, 100000);
	System.out.println(Arrays.toString(scores));
    }
}
