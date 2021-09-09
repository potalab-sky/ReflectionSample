package com.potalab.reflection;

@Disposition(Filling.ACTIVE)
public class BorderCollie implements Dog {
    private final String name;
    private final int age;

    public BorderCollie(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void shout() {
        System.out.println("name: " + name + "\tage: " + age);
    }
}
