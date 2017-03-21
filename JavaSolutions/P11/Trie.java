public class Trie {

    public static class TrieNode {
        TrieNode[] children;
	boolean isLeaf;

	public TrieNode() {
	    children = new TrieNode[26];
	    isLeaf = false;
	}
    }

    public TrieNode root;

    public Trie() {
	this.root = new TrieNode();
    }
    
    public void insert(String word) {
        if (word == null) return;
	word = word.toLowerCase();
	TrieNode curr = this.root;
	for (int i = 0; i < word.length(); i++) {
	    char c = word.charAt(i);
	    if (curr.children[c - 'a'] == null)
		curr.children[c - 'a'] = new TrieNode();
	    if (i == word.length() - 1) curr.isLeaf = true;
	    curr = curr.children[c - 'a'];
	}
    }

    public boolean search(String word) {
	if (word == null) return false;
	word = word.toLowerCase();
	TrieNode curr = this.root;
	for (int i = 0; i < word.length(); i++) {
	    int idx = word.charAt(i) - 'a';
	    if (curr.children[idx] == null) return false;
	    if (i == word.length() - 1) break;
	    curr = curr.children[idx];	    
	}
	return curr.isLeaf ? true : false;
    }

    public void exists(String word) {
	if (this.search(word))
	    System.out.println(word + " exists");
	else
	    System.out.println(word + " does NOT exist");
    }
    
    public static void main(String[] args) {
	Trie oak = new Trie();
	String[] words = {"home", "homework", "homeworkers",
			  "goat", "goatie", "good", "goodle",
			  "god", "goods", "homewo", "",
			  "homerworker"};
	for (int i = 0; i < words.length - 5; i++)
	    oak.insert(words[i]);
	for (int i = 0; i < words.length; i++)
	    oak.exists(words[i]);
    }
   
}
