package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.List;

public class Day1 {
    private List<Integer> list;

    public int solution_part1() {
        list = InputUtils.asIntList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day1.txt");
        int result = 0;
        for (int i = 1; i<list.size(); i++) {
            if (list.get(i) > list.get(i-1)) {
                result ++ ;
            }
        }
        return result;
    }

    // answer: 1728
    public int solution_part2() {
        list = InputUtils.asIntList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day1.txt");
        int result = 0;
        int pre = 0;
        for (int i = 0; i<list.size()-2; i++) {
            if (i == 0) {
                pre = list.get(i) + list.get(i+1) + list.get(i+2);
            } else {
                int cur = list.get(i) + list.get(i+1) + list.get(i+2);
                if ( cur > pre) {
                    result ++ ;
                }
                pre = cur;
            }
        }
        return result;
    }
}
