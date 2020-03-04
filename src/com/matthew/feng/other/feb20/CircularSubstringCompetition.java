package com.matthew.feng.other.feb20;

import java.util.HashSet;

public class CircularSubstringCompetition {

    public static void main(String[] args) {
        System.out.println(circularSubstringCompetition("aba", "abcdba"));
    }

    /*
     * Complete the 'circularSubstringCompetition' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. STRING target 2. STRING source
     */

    public static int circularSubstringCompetition(String target, String source) {
        // Write your code here
        source = source + source;

        int[] count = new int[26];
        HashSet<Character> sourceSet = new HashSet<>();
        for (char c : target.toCharArray()) {
            count[c - 'a']++;
            sourceSet.add(c);
        }
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while (right < source.length() - 1 && left < source.length() / 2) {
            if (valid(count)) {
                ans = Math.min(ans, right - left);
                left++;
                if (sourceSet.contains(source.charAt(left))) {
                    count[source.charAt(left) - 'a']++;
                }
            } else {
                right++;
                if (right < source.length() && sourceSet.contains(source.charAt(left))) {
                    count[source.charAt(right) - 'a']--;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;


    }

    private static boolean valid(int[] count) {
        for (int c : count) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
