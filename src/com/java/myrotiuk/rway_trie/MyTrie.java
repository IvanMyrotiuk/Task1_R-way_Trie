package com.java.myrotiuk.rway_trie;

public class MyTrie implements Trie {

	private static final int R = 26;
	private Node root = null;
	private int n;

	private static class Node {
		int value = 0;
		Node[] next = new Node[R];
	}

	@Override
	public void add(Tuple tuple) {
		root = put(root, tuple.getTerm(), tuple.getWeight(), 0);
	}

	private Node put(Node x, String term, int weight, int d) {
		if (x == null)
			x = new Node();
		if (d == term.length()) {
			if (x.value == 0)
				n++;
			x.value = weight;
			return x;
		}
		char c = term.charAt(d);
		int position = getPosition(c);
		x.next[position] = put(x.next[position], term, weight, d + 1);
		return x;
	}

	@Override
	public boolean contains(String word) {
		return get(word) != 0;
	}

	private int get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return 0;
		return x.value;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		int position = getPosition(c);
		return get(x.next[position], key, d + 1);
	}

	private int getPosition(char c) {
		if (c >= 65 && c <= 90) {
			return 90 - c;
		} else if (c >= 97 && c <= 122) {
			return 122 - c;
		}
		return -1;
	}

	@Override
	public boolean delete(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<String> words() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<String> wordsWithPrefix(String pref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return n;
	}
}
