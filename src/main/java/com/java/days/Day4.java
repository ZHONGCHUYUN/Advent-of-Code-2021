package com.java.days;

import com.java.days.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    public int solution() {
        List<String> list = InputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day4.txt");
        List<Integer> targets = List.of(list.get(0).split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<List<List<Integer>>> boards = new ArrayList<>();
        List<List<Integer>> board = new ArrayList<>();
        for (int i = 2; i<list.size(); i++) {
            if (list.get(i).length() == 0) {
                boards.add(board);
                board = new ArrayList<>();
            } else {
                board.add(List.of(list.get(i).trim().split("\\s+")).stream().map(Integer::parseInt).collect(Collectors.toList()));
            }
        }
        int boardSize = board.size();
        int numOfBoard = boards.size();
        int[][] verticals = new int[numOfBoard][boardSize];
        int[][] horizontal = new int[numOfBoard][boardSize];
        int[] diagonal = new int[numOfBoard];
        int[] antiDiagonal = new int[numOfBoard];
        for (int target: targets) {
            for (int k = 0; k<numOfBoard; k++) {
                for (int i = 0; i<boardSize; i++) {
                    for (int j = 0; j<boardSize; j++) {
                        if (boards.get(k).get(i).get(j) == target) {
                            boards.get(k).get(i).set(j, -1);
                            verticals[k][j] ++ ;
                            horizontal[k][i] ++ ;
                            if (i == j) diagonal[k] ++ ;
                            if (i+j+1 == boardSize) antiDiagonal[k] ++ ;
                            if (isVerticalLine(verticals[k], boardSize)) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                return sum * target;
                            } else if (isHorizontalLine(horizontal[k], boardSize)) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                return sum * target;
                            } else if (diagonal[k] == boardSize) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                return sum * target;
                            } else if (antiDiagonal[k] == boardSize) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                return sum * target;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int solution_part2() {
        List<String> list = InputUtils.asStringList("/Users/chuyunzhong/Desktop/Advent-of-Code-2021/src/main/java/com/java/resources/day4.txt");
        List<Integer> targets = List.of(list.get(0).split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<List<List<Integer>>> boards = new ArrayList<>();
        List<List<Integer>> board = new ArrayList<>();
        for (int i = 2; i<list.size(); i++) {
            if (list.get(i).length() == 0) {
                boards.add(board);
                board = new ArrayList<>();
            } else {
                board.add(List.of(list.get(i).trim().split("\\s+")).stream().map(Integer::parseInt).collect(Collectors.toList()));
            }
        }
        int boardSize = board.size();
        int numOfBoard = boards.size();
        int[][] verticals = new int[numOfBoard][boardSize];
        int[][] horizontal = new int[numOfBoard][boardSize];
        int[] diagonal = new int[numOfBoard];
        int[] antiDiagonal = new int[numOfBoard];
        int result = 0;
        boolean[] visited = new boolean[numOfBoard];
        for (int target: targets) {
            for (int k = 0; k<numOfBoard; k++) {
                for (int i = 0; i<boardSize; i++) {
                    for (int j = 0; j<boardSize; j++) {
                        if (boards.get(k).get(i).get(j) == target) {
                            boards.get(k).get(i).set(j, -1);
                            verticals[k][j] ++ ;
                            horizontal[k][i] ++ ;
                            if (i == j) diagonal[k] ++ ;
                            if (i+j+1 == boardSize) antiDiagonal[k] ++ ;
                            if (isVerticalLine(verticals[k], boardSize) && !visited[k]) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                result = sum * target;
                                visited[k] = true;
                            } else if (isHorizontalLine(horizontal[k], boardSize) && !visited[k]) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                result = sum * target;
                                visited[k] = true;
                            } else if (diagonal[k] == boardSize && !visited[k]) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                result = sum * target;
                                visited[k] = true;
                            } else if (antiDiagonal[k] == boardSize && !visited[k]) {
                                int sum = calculateUnmarkedSum(boards.get(k));
                                result = sum * target;
                                visited[k] = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private int calculateUnmarkedSum(List<List<Integer>> list) {
        int sum = 0;
        for (int i = 0; i<list.size(); i++) {
            for (int j = 0; j<list.get(0).size(); j++) {
                if (list.get(i).get(j) != -1) {
                    sum += list.get(i).get(j);
                }
            }
        }
        return sum;
    }

    private boolean isVerticalLine(int[] vertical, int winCondition) {
        for (int v: vertical) {
            if (v == winCondition) return true;
        }
        return false;
    }

    private boolean isHorizontalLine(int[] horizontal, int winCondition) {
        for (int h: horizontal) {
            if (h == winCondition) return true;
        }
        return false;
    }

}
