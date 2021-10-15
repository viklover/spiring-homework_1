package ru.springtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String args[]) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(getResources(args[0]));

        Base base = context.getBean("base", Base.class);
        base.print("GOOD DAY");

        context.close();
    }

    public static String[] getResources(String path) throws IOException {

        FileReader reader = new FileReader(path);
        String text = "";

        int c;
        while((c = reader.read()) != -1) {
            text += (char) c;
        }

        text = text.substring(text.indexOf("=")+1, text.length());

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        String[] modules = text.split(",");

        ArrayList<String> resources = new ArrayList<String>();

        for (int i = 0; i < modules.length; ++i) {
            Resource[] files = resourcePatternResolver.getResources("classpath*:"+modules[i]+"/*.spring.xml");

            for (int j = 0; j < files.length; ++j) {
                resources.add(files[j].getURL().toString());
                System.out.println();
            }
        }

        return resources.toArray(new String[resources.size()]);
    }
}
