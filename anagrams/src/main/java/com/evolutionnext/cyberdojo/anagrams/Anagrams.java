package com.evolutionnext.cyberdojo.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagrams {

    private Anagrams() {}

    private static String swap(String string) {
        char[] array = string.toCharArray();
        char[] result = new char[2];
        result[0] = array[1];
        result[1] = array[0];
        return new String(result);
    }

    public static List<String> shuffle(String string) {
        if (string.isEmpty() || string.length() == 1) return Collections.singletonList(string);
        else if (string.length() == 2) {
            return Arrays.asList(string, swap(string));
        } else {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
               String extracted = string.substring(i, i+1);
               List<String> rest = shuffle(string.substring(0, i) + string.substring(i + 1, string.length()));
               for (String combo : rest) {
                   result.add(extracted + combo);
               }
            }
            return result;
        }
    }
}
