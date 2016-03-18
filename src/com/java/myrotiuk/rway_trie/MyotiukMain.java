package com.java.myrotiuk.rway_trie;

public class MyotiukMain {
	public static void main(String[] args) {
		
		System.out.println("Hello world");
		MyTrie trie = new MyTrie();
		
		trie.add(new Tuple("qwerty", "qwerty".length()));
		
		System.out.println(trie.contains("qwerty"));
		System.out.println(trie.size());
	}
}
