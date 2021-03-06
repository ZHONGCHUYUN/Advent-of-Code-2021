package com.java.days.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class InputUtils {

    private static Scanner scanner;
    private static List<Integer> intList;
    private static List<String> stringList;

    public static List<Integer> asIntList(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
            intList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                intList.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return intList;
    }

    public static List<Integer> asIntListCommaSeparated(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
            intList = new ArrayList<>();
            if (scanner.hasNextLine()) {
                intList = List.of(scanner.nextLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return intList;
    }

    public static List<String> asStringList(String fileName) {
        try {
            stringList = new ArrayList<>();
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringList;
    }


}
