package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.List;

public class Day2 {

    public int solution() {
        List<String> list = InputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day2.txt");
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
