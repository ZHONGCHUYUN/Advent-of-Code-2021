package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.List;

public class Day3 {

    public  int solution() {
        List<String> list = InputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day3.txt");
        int numOfBit = list.get(0).length();
        int[] oneCounters = new int[numOfBit];
        int[] zeroCounters = new int[numOfBit];
        for (String line: list) {
            for (int i = 0; i<numOfBit; i++) {
                if (line.charAt(i) == '1') {
                    oneCounters[i] ++ ;
                } else {
                    zeroCounters[i] ++ ;
                }
            }
        }
        StringBuilder gammaStr = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i<numOfBit; i++) {
            if (oneCounters[i] > zeroCounters[i]) {
                gammaStr.append('1');
                epsilon.append('0');
            } else {
                gammaStr.append('0');
                epsilon.append('1');
            }
        }
        return Integer.parseInt(gammaStr.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
    }
}
