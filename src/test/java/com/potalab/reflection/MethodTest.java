package com.potalab.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Corgi.class;
        Object obj = clazz.newInstance();

        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isPrivate(method.getModifiers())) {
//                method.setAccessible(true);
            }
            method.invoke(obj);
        }
    }
}
