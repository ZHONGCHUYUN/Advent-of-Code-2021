package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.Collections;
import java.util.List;

public class Day7 {
    // answer: 328318
    public int method() {
        List<Integer> list = InputUtils.asIntListCommaSeparated("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day7.txt");
        Collections.sort(list);
        int median;
        if (list.size()%2 == 1) {
            median = list.get(list.size()/2);
        } else {
            median = (list.get(list.size()/2) + list.get(list.size()/2-1))/2;
        }
        int distance = 0;
        for (int num: list) {
            distance += Math.abs(num-median);
        }
        return distance;
    }
}
