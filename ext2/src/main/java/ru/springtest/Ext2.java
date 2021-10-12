package ru.springtest;

public class Ext2 implements Modification {
    public String acceptChanges(String text) {

        char[] symbols = new char[text.length() * 2];

        for (int i = 0; i < text.length(); ++i) {
            symbols[i] = text.charAt(i);
            symbols[text.length() - 1 + i] = text.charAt(i);
        }

        return "";
    }
}
