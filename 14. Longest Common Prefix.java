/**
 * Runtime: 4 ms, faster than 37.92% of Java online submissions for Longest
 * Common Prefix. Memory Usage: 35.9 MB, less than 99.54% of Java online
 * submissions for Longest Common Prefix.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        String shortest = "";
        if (strs.length < 1) {
            return "";
        }
        shortest = findingShortest(strs);
        for (int i = 0; i < shortest.length(); i++) {
            prefix = shortest.substring(0, i + 1);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].contains(prefix)) {
                    return prefix.substring(0, i);
                } else {
                    if (!strs[j].substring(0, prefix.length()).equals(prefix)) {
                        return prefix.substring(0, i);
                    }
                }
            }
        }
        return prefix;
    }

    private String findingShortest(String[] strs) {
        String shortest = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortest.length()) {
                shortest = strs[i];
            }
        }
        return shortest;
    }
}