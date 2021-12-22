package com.java;

import com.java.days.utils.InputUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static InputUtils inputUtils;

    public static void main(String[] args) {
	// write your code here
        System.out.println(method());
    }

    private static int method() {
        List<String> list = inputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/com/java/resources/day2.txt");
        int h = 0;
        int v = 0;
        for (String line: list) {
            String[] temp = line.split(" ");
            switch(temp[0]) {
                case "forward":
                    h += Integer.parseInt(temp[1]);
                    break;
                case "down":
                    v += Integer.parseInt(temp[1]);
                    break;
                case "up":
                    v -= Integer.parseInt(temp[1]);
                default :
                    break;
            }
        }
        return h*v;
    }
}
