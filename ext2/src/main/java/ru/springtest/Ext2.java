package ru.springtest;

import java.nio.file.WatchEvent;

public class Ext2 implements Modification {

    public String acceptChanges(String text) {

        char[] symbols = new char[text.length() * 2];

        for (int i = 0; i < text.length(); ++i) {
            symbols[i] = text.charAt(i);
            symbols[text.length() + i] = text.charAt(i);
        }

        return new String(symbols);
    }
}
