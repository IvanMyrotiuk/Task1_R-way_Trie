package com.java.myrotiuk.rway_trie;

public interface Trie {

    // ��������� � Trie ���� ����� - term, � ��� ��� - weight.
    // � �������� ���� ����������� ����� �����
	public void add(Tuple tuple);

    // ���� �� ����� � Trie
    public boolean contains(String word);

    // ������� ����� �� Trie
    public boolean delete(String word);

    // �������� �� ���� ������, ����� � ������
    public Iterable<String> words();

    // �������� �� ���� ������, ������������ � pref, ����� � ������
    public Iterable<String> wordsWithPrefix(String pref);

    // �-�� ���� � Trie
    public int size();

}
