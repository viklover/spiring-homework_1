package ru.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Launcher {

    public static String pathToContext = "applicationContext.xml";

    public static void main(String args[]) throws IOException {

        //createAppContextFile(parseModifications(args[0]));

//        System.out.println(System.getProperty("user.dir"));

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(context.getBeanDefinitionCount());

        Base base = context.getBean("base", Base.class);

        base.print("GOOD DAY");

//        context.close();


        System.out.println("HELLO WORLD");
    }

    public static String[] parseModifications(String path) throws IOException {
        FileReader reader = new FileReader(path);
        String text = "";

        int c;
        while((c = reader.read()) != -1) {
            text += (char) c;
        }

        ArrayList<String> modifications = new ArrayList<String>();

        text = text.substring(0, text.indexOf("=")+1);

        return text.split(",");
    }

    public static void createAppContextFile(String[] modifications) throws IOException {

        FileWriter writer = new FileWriter(pathToContext, false);

//        String content = "";
//
//
//        try(FileWriter writer = new FileWriter(pathToContext, false))
//        {
//            // запись всей строки
//            String text = "Hello Gold!";
//            writer.write(text);
//            // запись по символам
//            writer.append('\n');
//            writer.append('E');
//
//            writer.flush();
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }

    }
}
