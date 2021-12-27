package com.java.days;

import com.java.days.utils.InputUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day5 {
    public  int solution() {
        List<String> list = InputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day5.txt");
        List<List<Integer>> coordinates = new ArrayList<>();
        for (String line: list) {
            coordinates.add(List.of(line.split("[^\\d*]")).stream().filter(e -> !StringUtils.isEmpty(e)).map(Integer::parseInt).collect(Collectors.toList()));
        }
        int result = 0;
        Map<String, Integer> hashMap = new HashMap<>();
        for (List<Integer> coordinate: coordinates) {
            int x1 = coordinate.get(0);
            int x2 = coordinate.get(2);
            int y1 = coordinate.get(1);
            int y2 = coordinate.get(3);
            if (x1 == x2) {
                for (int y = Math.min(y1, y2); y<=Math.max(y1, y2); y++) {
                    if (hashMap.containsKey(x1 + "," + y) && hashMap.get(x1 + "," + y) == 1) {
                        result ++ ;
                        hashMap.put(x1 + "," + y, 2);
                    } else {
                        hashMap.put(x1 + "," + y, hashMap.getOrDefault(x1 + "," + y, 0) + 1);
                    }
                }
            } else if (y1 == y2) {
                for (int x = Math.min(x1, x2); x<=Math.max(x1, x2); x++) {
                    if (hashMap.containsKey(x + "," + y1) && hashMap.get(x + "," + y1) == 1) {
                        result ++ ;
                        hashMap.put(x + "," + y1, 2);
                    } else {
                        hashMap.put(x + "," + y1, hashMap.getOrDefault(x + "," + y1, 0)+1);
                    }
                }
            }
        }
        return result;

    }
}
