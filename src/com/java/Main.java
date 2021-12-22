package com.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(method());
    }

    private static int method() {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/com/java/resources/day1.txt"));
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int result = 0;
        for (int i = 1; i<list.size(); i++) {
            if (list.get(i) > list.get(i-1)) {
                result ++ ;
            }
        }
        return result;
    }
}
