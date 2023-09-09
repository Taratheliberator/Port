package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<List<Integer>> transform(String[] indexes) {
        List<List<Integer>> transformedList = new ArrayList<>();
        for (String index : indexes) {
            List<Integer> numbers = new ArrayList<>();
            String[] splitIndexes = index.split(",");
            for (String splitIndex : splitIndexes) {
                if (splitIndex.contains("-")) {
                    String[] range = splitIndex.split("-");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    for (int i = start; i <= end; i++) {
                        numbers.add(i);
                    }
                } else {
                    numbers.add(Integer.parseInt(splitIndex));
                }
            }
            transformedList.add(numbers);
        }
        return generateCombinations(transformedList);
    }

    private static List<List<Integer>> generateCombinations(List<List<Integer>> lists) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinationsHelper(lists, combinations, new Stack<>(), 0);
        return combinations;
    }

    private static void generateCombinationsHelper(List<List<Integer>> lists, List<List<Integer>> result, Stack<Integer> current, int index) {
        if (index == lists.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < lists.get(index).size(); i++) {
            current.push(lists.get(index).get(i));
            generateCombinationsHelper(lists, result, current, index + 1);
            current.pop();
        }
    }

    public static void main(String[] args) {
        String[] indexes = {"1,3-5", "2", "3-4"};
        List<List<Integer>> result = transform(indexes);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}


