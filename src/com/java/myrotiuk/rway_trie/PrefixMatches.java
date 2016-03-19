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
		checkLength(pref);
		return getWordsWithPrefix(pref, k);
	}

	// ���� ��������� pref ������� ��� ����� 2� ��������, �� ���������� �����
	// ���� k=3 ������ ���� ������� � �����������, � ������������ � �������
	// �������� pref.
	public Iterable<String> wordsWithPrefix(String pref){
		checkLength(pref);
		return getWordsWithPrefix(pref, 3);
	}
	
	private void checkLength(String pref){
		if(pref.length() < 2)
			throw new IllegalArgumentException("Length of prefix less then 2");
	}
	
	private Iterable<String> getWordsWithPrefix(String pref, final int kk){
		Queue<String> myWords = (Queue<String>)trie.wordsWithPrefix(pref);
		return new Iterable<String>(){
			public Iterator<String> iterator(){
				return new Iterator<String>(){
					int k = kk;
					int n = 1;
					int length_prev;
					int triger = 1;
					boolean stopiteration = false;
					public boolean hasNext(){
						if(myWords.size() != 0 && triger == 1){
							length_prev = myWords.peek().length();
							triger = 0;
						}
						if(myWords.size() == 0){
							return false;
						}
						String word = myWords.peek();
						int length = word.length();
						if(length != length_prev && kk == 1){
							return false;
						}
						if(stopiteration){
							return false;
						}else if(kk == 1){
							return true;
						}
						if(n != k+1){
							return true;
						}
						return false;
					}
					
					public String next(){
						String word = myWords.poll();
						int length = word.length();
						if(length != length_prev){
							length_prev = length;
							if(kk == 1){
								stopiteration = true;
							}
							n++;
						}
						return word;
					}
				};
			}
		};
	}

}