/**
 * Runtime: 755 ms, faster than 5.04% of Java online submissions for Container
 * With Most Water. Memory Usage: 39.3 MB, less than 97.00% of Java online
 * submissions for Container With Most Water.
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = 0;
        int max_sqr = 0;
        for (int i = 0; i < height.length; i++) {
            left = height[i];
            for (int j = i; j < height.length; j++) {
                if (i != j) {
                    right = height[j];
                    if (right <= left) {
                        int temp_sqr = right * (j - i);
                        if (temp_sqr > max_sqr) {
                            max_sqr = temp_sqr;
                        }
                    }
                }
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            right = height[i];
            for (int j = i; j >= 0; j--) {
                if (i != j) {
                    left = height[j];
                    if (right >= left) {
                        int temp_sqr = left * (i - j);
                        if (temp_sqr > max_sqr) {
                            max_sqr = temp_sqr;
                        }
                    }
                }
            }
        }
        return max_sqr;
    }
}