package com.kp.chukhnovm.class8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        task1();
        serialize();
    }

    public static void task1(){
        Cat cat1 = new Cat("Name", "grey");
        Cat cat2 = new Cat("Name", "grey");

        System.out.println(cat1);

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());

        Cat cat3 = null;

        try {
            cat3 = cat1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Class catClass1 = Cat.class;
        Class catClass2 = cat1.getClass();


        System.out.println(catClass1);
        System.out.println(catClass2);

        Field[] fields = catClass1.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        //
        Method[] methods = catClass2.getDeclaredMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        {
            Class catClass3 = Cat.class;
            Class[] interfaces = catClass3.getInterfaces();

            for (int i = 0; i < interfaces.length; i++) {
                if (interfaces[i].equals(Cloneable.class)) {
                    System.out.println("Cat cloneable ON");
                }
            }
        }

        {
            try {
                Field catAge = catClass1.getDeclaredField("name");
                catAge.setAccessible(true);
                catAge.setInt(cat1, 100500);
            } catch (NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
    }

    // Можно ли из 2 потоков иметь доступ к обьекту в оперативной памяти
    //String -> byte[] ?
    //Рефлексия и в тестировании приватных методов используется?
    public static void serialize(){

    }
}
