package com.java.myrotiuk.rway_trie;

public class MyotiukMain {
	public static void main(String[] args) {

		MyTrie trie = new MyTrie();
		
		trie.add(new Tuple("qwerty", "qwerty".length()));
		
		System.out.println(trie.contains("qwerty"));
		System.out.println(trie.size());
		System.out.println(trie.delete("qwerty"));
		System.out.println(trie.contains("qwerty"));
		System.out.println(trie.size());
		
		trie.add(new Tuple("abc", 1));
		trie.add(new Tuple("ab", 1));
		trie.add(new Tuple("a", 1));
		System.out.println(trie.contains("abc"));
		System.out.println(trie.contains("ab"));
		System.out.println(trie.contains("a"));
		System.out.println("size:"+trie.size());
		System.out.println("deletion");
		System.out.println(trie.delete("a"));
		System.out.println("size:"+trie.size());
		System.out.println(trie.delete("ab"));
		System.out.println("size:"+trie.size());
		System.out.println(trie.delete("abc"));
		System.out.println("size:"+trie.size());
		
		
		StringBuilder strBuilder = new StringBuilder("");
		char c = 97;
		strBuilder.append(c);
		System.out.println(strBuilder.toString());
		
		trie.add(new Tuple("abcdlekljhn", 1));
		trie.add(new Tuple("abcdlekjhn", 1));
		trie.add(new Tuple("abcdle", 1));
		trie.add(new Tuple("abcdol", 1));
		trie.add(new Tuple("abcde", 1));
		trie.add(new Tuple("abcdo", 1));
		trie.add(new Tuple("abc", 1));
		trie.add(new Tuple("abh", 1));
		trie.add(new Tuple("abu", 1));
		trie.add(new Tuple("abk", 1));
		trie.add(new Tuple("a", 1));
		System.out.println("--Iterator--");
		for(String r: trie.words()){
			System.out.println(r);
		}
		
		for(String r: trie.wordsWithPrefix("a")){
			System.out.println(r);
		}
		System.out.println("Prefix matcher");
		PrefixMatches pm = new PrefixMatches(trie);
		for(String r : pm.wordsWithPrefix("ab")){
			System.out.println(r);
		}
		
		System.out.println("Iterable 2");
		for(String r : pm.wordsWithPrefix("ab", 5)){
			System.out.println(r);
		}
		
		
	}
}
