package com.jihogrammer.algo.compare;

public class Writer implements Comparable<Writer> {

    int num;
    String name;
    int age;
    String title;

    public Writer(int num, String name, int age, String title) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Writer [num=" + num + ", name=" + name + ", age=" + age + ", title=" + title + "]";
    }

    @Override
    public int compareTo(Writer o) {
        return this.num - o.num;
    }
    
}
