package com.potalab.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class ClassTest {
    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> collie = Class.forName("com.potalab.reflection.BorderCollie");
        for (Method method : collie.getMethods()) {
            System.out.println(method);
        }

        System.out.println("-------------");
        for (Method method : collie.getDeclaredMethods()) {
            System.out.println(method);
        }

        Object obj = collie.getConstructor(String.class, int.class).newInstance("test", 5);
        collie.getMethod("shout").invoke(obj);

        Class<?> corgi = Class.forName("com.potalab.reflection.Welsh");
        if (corgi.isAnnotationPresent(Type.class)) {
            System.out.println(collie.getAnnotation(Type.class).value());
        }
    }

    @Test
    public void genericTest() throws ClassNotFoundException {
        Class<?> cat = Class.forName("com.potalab.reflection.Munchkin");
        java.lang.reflect.Type genericType = getClassGenericType(cat);
        System.out.println(genericType);
    }

    public java.lang.reflect.Type getClassGenericType(Class<?> clazz) {
        java.lang.reflect.Type genericType = null;
        java.lang.reflect.Type[] interfaces = clazz.getGenericInterfaces();
        if (interfaces.length <= 0) {
            return null;
        }
        java.lang.reflect.Type interfaceType = interfaces[0];
        if (interfaceType instanceof ParameterizedType) {
            genericType = getTypeArguments((ParameterizedType) interfaceType);
        }
        return genericType;
    }
    private java.lang.reflect.Type getTypeArguments(ParameterizedType type) {
        java.lang.reflect.Type[] typeArguments = type.getActualTypeArguments();
        return typeArguments.length > 0 ? typeArguments[0] : null;
    }
}