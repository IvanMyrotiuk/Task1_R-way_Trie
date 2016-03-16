package com.java.myrotiuk.rway_trie;

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

	// ���� �� ����� � �������
	public boolean contains(String word) {
		return false;
	}

	// ������� ����� �� �������
	public boolean delete(String word) {
		return false;
	}

	// �-�� ���� � �������
	public int size() {
		return 0;
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
	public Iterable<String> wordsWithPrefix(String pref, int k){
		return null;
	}

	// ���� ��������� pref ������� ��� ����� 2� ��������, �� ���������� �����
	// ���� k=3 ������ ���� ������� � �����������, � ������������ � �������
	// �������� pref.
	public Iterable<String> wordsWithPrefix(String pref){
		return null;
	}
}
//http://stackoverflow.com/questions/23162559/iterable-as-a-return-type
//http://algs4.cs.princeton.edu/52trie/