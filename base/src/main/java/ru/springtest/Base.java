package ru.springtest;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Base {

    public Modification[] modules;

    public String text = "Hello World";

    public Resource[] resources;

    public Base() {

    }

    private void printResources(java.io.InputStream stream) {
        System.out.println(stream);
    }

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

