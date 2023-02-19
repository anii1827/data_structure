package triedatastructure;

/**
 * 
 * @author anii<br>
 *
 * client class the test the functionality 
 */
public class TrieDataStructurePart1 {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		System.out.println("add 'anil' into trie");
		trie.add("anil");
		System.out.println("add 'anna' into trie");
		trie.add("anna");
		System.out.println("add 'anii' into trie");
		trie.add("anii");
		System.out.println("add 'bac' into trie");
		trie.add("bac");
		
		System.out.println("is trie contains anil = " + trie.isContains("anil"));
		System.out.println("is trie contains bac = "+  trie.isContains("bac"));
		System.out.println("is trie contains xyz = "+trie.isContains("xyz"));
		System.out.println("is trie contains prefix an = "+ trie.isContainsPrefix("an"));
		System.out.println("is trie contains prfixe ba = "+trie.isContainsPrefix("ba"));
		System.out.println("is trie contains prfixe xy = "+trie.isContainsPrefix("xy"));	
	}

}


/**
 * 
 * @author anii<br>
 *
 * 
 * The basic implementation of Trie data structure <br>
 * provide the functionality of add, check string, check the prefix.
 */
class Trie{
	private Node node;
	
	public Trie() {
		node = new Node();
	}
	
	public void add(String str){
		Node temp = node;
		for(int x=0;x<str.length();x++) {
			if(!temp.contains(str.charAt(x))) {
				temp.add(str.charAt(x), new Node());
			}
			temp = temp.next(str.charAt(x));
		}
		temp.islast=true;
	}
	
	public boolean isContains(String str) {
		Node temp = node;
		for(int x=0;x<str.length();x++) {
			if(!temp.contains(str.charAt(x))) {
				return false;
			}
			temp = temp.next(str.charAt(x));
		}
		return temp.islast;
	}
	
	public boolean isContainsPrefix(String str) {
		Node temp = node;
		for(int x=0;x<str.length();x++) {
			if(!temp.contains(str.charAt(x))) {
				return false;
			}
			temp = temp.next(str.charAt(x));
		}
		return true;
	}
}

/**
 * 
 * @author anii<br>
 * 
 * <h1>required structure to implement the TrieDataStructure.<h1>
 *
 */
class Node{
	
	private Node [] linkes;
	boolean islast;
	
	public Node() {
		linkes = new Node[26];
		islast = false;
	}

	public Node next(char ch) {	
		return linkes[ch-'a'];
	}

	public void add(char charAt, Node node) {
		linkes[charAt-'a']=node;
		
	}

	public boolean contains(char charAt) {
		return linkes[charAt-'a'] != null;
	}
}
