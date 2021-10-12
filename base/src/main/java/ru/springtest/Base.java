package ru.springtest;

import java.util.ArrayList;

public class Base {

    public Modification[] modules;

    public void print(String text) {
        for (Modification mode : modules) {
            text = mode.acceptChanges(text);
        }
        System.out.println(text);
    }

    public void setModules(Modification[] modules) {
        this.modules = modules;
    }
}

