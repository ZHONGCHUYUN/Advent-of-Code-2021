package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6 {

    // answer: 385391
    public int solution() {
        List<Integer> list = InputUtils.asIntListCommaSeparated("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day6.txt");
        for (int k = 0; k<80; k++) {
            int newNumber = 0;
            for (int i = 0; i<list.size(); i++) {
                if (list.get(i) == 0) {
                    newNumber ++ ;
                    list.set(i, 7);
                }
                list.set(i, list.get(i)-1);
            }
            for (int j = 0; j<newNumber; j++) {
                list.add(8);
            }
        }
        return list.size();
    }

    // answer: 1728611055389
    public long solution_part2() {
        List<Integer> list = InputUtils.asIntListCommaSeparated("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day6.txt");
        Map<Integer, Long> fish = new HashMap<>();
        for (int timer: list) {
            fish.put(timer, fish.getOrDefault(timer, 0L) + 1);
        }
        for (int k = 0; k<256; k++) {
            Map<Integer, Long> copy = new HashMap<>();
            for (int timer: fish.keySet()) {
                if (timer>0) {
                    copy.put(timer - 1, copy.getOrDefault(timer-1, 0L) + fish.get(timer));
                } else if (timer == 0) {
                    copy.put(6, copy.getOrDefault(6, 0L) + fish.get(timer));
                    copy.put(8, fish.get(timer));
                }
            }
            fish = copy;
        }
        long result = 0;
        for (Map.Entry<Integer, Long> entry: fish.entrySet()) {
            result += entry.getValue();
        }
        return result;
    }

}
