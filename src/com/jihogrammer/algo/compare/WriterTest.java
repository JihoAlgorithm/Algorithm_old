package com.jihogrammer.algo.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WriterTest {

    public static void main(String[] args) {

        ArrayList<Writer> list = new ArrayList<>();

        list.add(new Writer(3, "Tommy", 35, "Hello Java"));
        list.add(new Writer(2, "Jane", 45, "Stop Java"));
        list.add(new Writer(1, "Bill", 40, "Sing Java"));
        list.add(new Writer(4, "Kim", 22, "Bye Java"));
        list.add(new Writer(5, "Tommy", 55, "Good Java"));

        Collections.sort(list);
        for (Writer w : list) System.out.println(w);

        Collections.sort(list, new WriterNameComparator());
        for (Writer w : list) System.out.println(w);

        Collections.sort(list, new Comparator<Writer>(){
            @Override
            public int compare(Writer o1, Writer o2) {
                return o1.age - o2.age;
            }
        });
        for (Writer w : list) System.out.println(w);
        
    }
    
}
