package com.sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByPattern {

  public static void main(String args[]) {
    String result = sortByPattern("Azcba1", "123AaBbCcZz");
    System.out.println(result);
  }

  private static String sortByPattern(String input, String pattern) {
    Map<String, String> occurrenceMap = Arrays.stream(input.split(""))
        .collect(Collectors.groupingBy(s -> s, Collectors.joining()));
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pattern.length(); i++) {
      sb.append(occurrenceMap.getOrDefault(String.valueOf(pattern.charAt(i)), ""));
    }
    return sb.toString();
  }
}
