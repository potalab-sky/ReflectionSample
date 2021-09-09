package com.potalab.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {
    @Test
    public void test() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName("com.potalab.reflection.Corgi");
        Method method = clazz.getMethod("secret", String.class, boolean.class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println(parameter);
        }
    }
}
