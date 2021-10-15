package ru.springtest;

import java.util.Locale;

public class Ext1 implements Modification {

    public String acceptChanges(String text) {
        return text.toUpperCase(Locale.ROOT);
    }
}
