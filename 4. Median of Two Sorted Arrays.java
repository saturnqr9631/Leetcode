/**
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Median of Two Sorted Arrays.
Memory Usage: 46.9 MB, less than 94.06% of Java online submissions for Median of Two Sorted Arrays.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        double median = 0;
        int[]  merged = null;  
        if(nums1 ==null)
        {
            merged = nums2;
        }else if(nums2 ==null)
        {
            merged = nums1;
        }else{
            merged = merge(nums1, nums2);
        }
        if(merged.length %2 ==0)
        {
            median = (merged[merged.length/2]+merged[merged.length/2-1])/2.0;
        }else{
            median = merged[merged.length/2];
        }
        return median;
    }
    public int[] merge(int[] nums1, int[] nums2)
    {
        int[] merged = new int[nums1.length+nums2.length];
        int   pos1   = 0;
        int   pos2   = 0;
        int   length1 = nums1.length;
        int   length2 = nums2.length;
        for(int i = 0; i<merged.length; i++)
        {
            if(pos1<length1 && pos2<length2)
            {
                if(nums1[pos1]<nums2[pos2])
                {
                    merged[i] = nums1[pos1];
                    pos1++;
                }else{
                    merged[i] = nums2[pos2];
                    pos2++;
                }
            }else{
                if(pos1<length1)
                {
                    merged[i] = nums1[pos1];
                    pos1++;
                }else{
                    merged[i] = nums2[pos2];
                    pos2++;
                }
            }
            

            
        }
        return merged;
    }
}