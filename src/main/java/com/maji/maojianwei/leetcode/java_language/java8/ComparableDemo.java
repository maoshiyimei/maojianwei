package com.maji.maojianwei.leetcode.java_language.java8;



import java.util.Objects;


public class ComparableDemo implements Comparable<ComparableDemo>{
    private int age;

    private String name ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        ComparableDemo that = (ComparableDemo) o;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(ComparableDemo o) {
        return this.age - o.getAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
