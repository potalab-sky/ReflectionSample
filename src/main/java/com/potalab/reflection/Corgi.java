package com.potalab.reflection;

@Type("Dog")
@Disposition(Filling.HAPPY)
public class Corgi implements Dog {
    @Override
    public void shout() {
        System.out.println("...");
    }

    private void secret(String msg, boolean secret) {
        System.out.println("hello");
    }

    protected void show() {
        System.out.println("rolling");
    }
}
