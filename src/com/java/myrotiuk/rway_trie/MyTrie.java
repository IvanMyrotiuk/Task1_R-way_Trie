package com.java.myrotiuk.rway_trie;

import java.util.LinkedList;
import java.util.Queue;

public class MyTrie implements Trie {

	private static final int R = 26;
	private Node root = null;
	private int n;

	private static class Node {
		int weight = 0;
		Node[] next = new Node[R];
	}

	@Override
	public void add(Tuple tuple) {
		root = put(root, tuple.getWord(), tuple.getWeight(), 0);
	}

	private Node put(Node x, String word, int weight, int d) {
		if (x == null)
			x = new Node();
		if (d == word.length()) {
			x.weight = weight;
			n++;
			// if (x.weight == 0) {
			// n++;
			// }
			return x;
		}
		char c = word.charAt(d);
		int position = getPosition(c);
		x.next[position] = put(x.next[position], word, weight, d + 1);
		return x;
	}

	@Override
	public boolean contains(String word) {
		Node x = get(root, word, 0);
		if (x == null) {
			return false;
		}
		return true;
	}

	private Node get(Node x, String word, int d) {

		if (x == null) {
			return null;
		}
		if (d == word.length()) {
			return x;
		}
		char c = word.charAt(d);
		int position = getPosition(c);
		return get(x.next[position], word, d + 1);
	}

	private int getPosition(char c) {
		if (c >= 65 && c <= 90) {
			return c - 65;
		} else if (c >= 97 && c <= 122) {
			return c - 97;
		}
		return -1;
	}

	@Override
	public boolean delete(String word) {
		Node refRoot = root;
		Node x = delete(root, refRoot, word, 0);
		if (x != null) {
			return false;
		}
		n--;
		return true;
	}

	private Node delete(Node x, Node refX, String word, int d) {
		if (x == null) {
			return null;
		}
		if (d == word.length()) {
			if (x.weight == 0) {
				return null;
			}
			x.weight = 0;
			boolean canBeDeleted = true;
			for (int i = 0; i < R; i++) {
				if (x.next[i] != null) {
					canBeDeleted = false;
				}
				if (canBeDeleted == true) {
					char c = word.charAt(d - 1);
					int position = getPosition(c);
					refX.next[position] = null;
				}
			}
			return null;
		}
		char c = word.charAt(d);
		int position = getPosition(c);
		refX = x;
		Node tmp = delete(x.next[position], refX, word, d + 1);
		// deleting up by trunk
		if (tmp == null) {
			if (d - 1 == -1) {
				return null;// delete root
			}
			if (x.weight == 0) {
				boolean canBeDeleted = true;
				for (int i = 0; i < R; i++) {
					if (x.next[i] != null) {
						canBeDeleted = false;
					}
					if (canBeDeleted == true) {
						c = word.charAt(d - 1);// another char
						position = getPosition(c);// another position
						refX.next[position] = null;
					}
				}
				return null;
			}
		}
		return tmp;
	}

	@Override
	public Iterable<String> words() {
		return wordsWithPrefix("");
	}

	public Iterable<String> wordsWithPrefix(String prefix) {
		Queue<String> results = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, Queue<String> results) {
		if (x == null) return;
		if (x.weight != 0) results.offer(prefix.toString());
		for (char c = 0; c < R; c++) {
			prefix.append((char) (c + 97));
			collect(x.next[c], prefix, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}  

	@Override
	public int size() {
		return n;
	}
}
