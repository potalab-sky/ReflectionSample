package com.potalab.reflection;

import java.util.List;

public class Munchkin implements Cat<List<String>, String> {

    @Override
    public void crying(List<String> val, String val2) {
    }

    public void show(@Param(1)String str, @Param(0)String str1) {
    }
}
