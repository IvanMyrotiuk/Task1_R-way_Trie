package com.java.myrotiuk.rway_trie;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.attribute.standard.RequestingUserName;

public class PrefixMatches {
	private Trie trie;

	// ��������� in-memory ������� ����. ����� ��������� �����, ������, ������
	// ����/�����. ���� �������� ������, �� ��� ����������� �� ����� ��
	// ��������.
	// � ������� ������ ����������� ����� ������� 2� ��������. ��������������
	// ��� ����� ���������� �����������.
	public int add(String... strings) {
		return 0;
	}

	public PrefixMatches(Trie trie){
		this.trie = trie;
	}
	
	// ���� �� ����� � �������
	public boolean contains(String word) {
		return trie.contains(word);
	}

	// ������� ����� �� �������
	public boolean delete(String word) {
		return trie.delete(word);
	}

	// �-�� ���� � �������
	public int size() {
		return trie.size();
	}

	// ���� ��������� pref ������� ��� ����� 2� ��������, �� ���������� �����
	// ���� k ������ ���� ������� � �����������, � ������������ � �������
	// �������� pref.
	// ������, ���� ����� ��������� ����� � pref='abc':
	// abc 3
	// abcd 4
	// abce 4
	// abcde 5
	// abcdef 6
	// - ��� k=1 ������������ 'abc'
	// - ��� k=2 ������������ 'abc', 'abcd', 'abce'
	// - ��� k=3 ������������ 'abc', 'abcd', 'abce', 'abcde'
	// - ��� k=4 ������������ 'abc', 'abcd', 'abce', 'abcde', 'abcdef'
	public Iterable<String> wordsWithPrefix(String pref, int k) {
		return getWordsWithPrefix(pref, k);
	}

	// ���� ��������� pref ������� ��� ����� 2� ��������, �� ���������� �����
	// ���� k=3 ������ ���� ������� � �����������, � ������������ � �������
	// �������� pref.
	public Iterable<String> wordsWithPrefix(String pref){
		
		return getWordsWithPrefix(pref, 3);
//		if(pref.length() >= 2){
//			Queue<String> results = new LinkedList<String>();
//			Node x = get(root, prefix, 0);
//			collect(x, new StringBuilder(prefix), results);
//			return results;
//		}
//		return null;
	}
	
//////////////////////////////////////
	
	private Iterable<String> getWordsWithPrefix(String pref, final int kk){	
		Queue<String> myWords = (Queue<String>)trie.wordsWithPrefix(pref);
		return new Iterable<String>(){
			public Iterator<String> iterator(){
				return new Iterator<String>(){
					int k = kk;
					int n = 1;
					int length_prev = myWords.peek().length();
					public boolean hasNext(){
						if(myWords.size() == 0){
							return false;
						}
//						if(kk == 1){
//							return true;
//						}
						if(n != k){
							return true;
						}
						return false;
					}
					
					public String next(){
						String word = myWords.poll();
						int length = word.length();
						if(length != length_prev){
							length_prev = length;
							n++;
							if( kk == 1){
								k--;
							}
						}
						return word;
					}
				};
			}
		};
	}

	// private void collect(Node x, StringBuilder prefix, Queue<String> results,
	// int times, int k) {
	// if(times == k){
	//
	// }
	// if (x == null) return;
	// if (x.weight != 0) results.offer(prefix.toString());
	// for (char c = 0; c < R; c++) {
	// prefix.append((char) (c + 97));
	// collect(x.next[c], prefix, results, times + 1, k);
	// prefix.deleteCharAt(prefix.length() - 1);
	// }
	// }
}