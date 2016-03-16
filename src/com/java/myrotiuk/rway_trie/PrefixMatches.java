package com.java.myrotiuk.rway_trie;

public class PrefixMatches {
	private Trie trie;

	// ‘ормирует in-memory словарь слов. ћетод принимает слово, строку, массив
	// слов/строк. ≈сли приходит строка, то она разбиваетс€ на слова по
	// пробелам.
	// ¬ словарь должны добавл€тьс€ слова длиннее 2х символов. ѕредполагаетс€
	// что знаки пунктуации отсутствуют.
	public int add(String... strings) {
		return 0;
	}

	// есть ли слово в словаре
	public boolean contains(String word) {
		return false;
	}

	// удал€ет слово из словар€
	public boolean delete(String word) {
		return false;
	}

	// к-во слов в словаре
	public int size() {
		return 0;
	}

	// если введенный pref длиннее или равен 2м символам, то возвращает набор
	// слов k разных длин начина€ с минимальной, и начинающихс€ с данного
	// префикса pref.
	// ѕример, даны слова следующей длины и pref='abc':
	// abc 3
	// abcd 4
	// abce 4
	// abcde 5
	// abcdef 6
	// - при k=1 возвращаютс€ 'abc'
	// - при k=2 возвращаютс€ 'abc', 'abcd', 'abce'
	// - при k=3 возвращаютс€ 'abc', 'abcd', 'abce', 'abcde'
	// - при k=4 возвращаютс€ 'abc', 'abcd', 'abce', 'abcde', 'abcdef'
	public Iterable<String> wordsWithPrefix(String pref, int k){
		return null;
	}

	// если введенный pref длиннее или равен 2м символам, то возвращает набор
	// слов k=3 разных длин начина€ с минимальной, и начинающихс€ с данного
	// префикса pref.
	public Iterable<String> wordsWithPrefix(String pref){
		return null;
	}
}
//http://stackoverflow.com/questions/23162559/iterable-as-a-return-type
//http://algs4.cs.princeton.edu/52trie/