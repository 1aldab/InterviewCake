import java.util.*;

public class StringPermutator {

    public static Set<String> getPerms(String s) {
	if (s.length() == 1) {
	    Set<String> perms = new HashSet<String>();
	    perms.add(s);
	    return perms;
	}
	Set<String> perms = new HashSet<String>();
	for (int i = 0; i < s.length(); i++) {
	    String rem = s.substring(0,i) + s.substring(i+1);
	    Set<String> shortPerms = getPerms(rem);
	    for (String perm : shortPerms) {
		perms.add(s.substring(i, i+1) + perm);
	    }	    
	}
	return perms;
    }

    public static void main(String[] args) {
	Set<String> perms = getPerms("abc");
	for (String perm : perms) System.out.println(perm);
    }

}
