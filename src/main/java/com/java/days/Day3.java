package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.ArrayList;
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


    public int solution_part2() {
        List<String> list = InputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day3.txt");
        int numOfBit = list.get(0).length();
        String oxygenRating = calculateOxygenRating(list, numOfBit);
        String co2Rating = calculateCO2Rating(list, numOfBit);
        return Integer.parseInt(oxygenRating, 2)*Integer.parseInt(co2Rating, 2);
    }

    private  String calculateOxygenRating(List<String> list, int numOfBit) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < numOfBit; i++) {
            if (indexes.size() == 1) {
                return list.get(indexes.get(0));
            }
            List<Integer> zeroList = new ArrayList<>();
            List<Integer> oneList = new ArrayList<>();
            int numOfZero = 0, numOfOne = 0;
            if (indexes.isEmpty()) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).charAt(i) == '0') {
                        zeroList.add(j);
                        numOfZero++;
                    } else {
                        oneList.add(j);
                        numOfOne++;
                    }
                }
            } else {
                for (int index : indexes) {
                    if (list.get(index).charAt(i) == '0') {
                        zeroList.add(index);
                        numOfZero++;
                    } else {
                        oneList.add(index);
                        numOfOne++;
                    }
                }
            }
            if (zeroList.size() <= oneList.size()) {
                indexes = oneList;
            } else {
                indexes = zeroList;
            }
        }
        return indexes.isEmpty()?"":list.get(indexes.get(0));
    }

    private String calculateCO2Rating(List<String> list, int numOfBit) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < numOfBit; i++) {
            if (indexes.size() == 1) {
                return list.get(indexes.get(0));
            }
            List<Integer> zeroList = new ArrayList<>();
            List<Integer> oneList = new ArrayList<>();
            int numOfZero = 0, numOfOne = 0;
            if (indexes.isEmpty()) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).charAt(i) == '0') {
                        zeroList.add(j);
                        numOfZero++;
                    } else {
                        oneList.add(j);
                        numOfOne++;
                    }
                }
            } else {
                for (int index : indexes) {
                    if (list.get(index).charAt(i) == '0') {
                        zeroList.add(index);
                        numOfZero++;
                    } else {
                        oneList.add(index);
                        numOfOne++;
                    }
                }
            }
            if (zeroList.size() <= oneList.size()) {
                indexes = zeroList;
            } else {
                indexes = oneList;
            }
        }
        return indexes.isEmpty()?"":list.get(indexes.get(0));
    }
}
