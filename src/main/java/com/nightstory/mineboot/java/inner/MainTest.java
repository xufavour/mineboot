package com.nightstory.mineboot.java.inner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: putao
 * @Date: 2018/12/18
 */
public class MainTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered.size());


    }
}

