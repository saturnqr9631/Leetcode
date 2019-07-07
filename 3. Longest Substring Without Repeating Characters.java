
/**
 * Runtime: 140 ms, faster than 6.83% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 37.4 MB, less than 52.52% of Java online submissions for Longest Substring Without Repeating Characters.
 *  */
class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int result = 0;
        for(int i=0; i<s.length();i++)
        {
            for(int j =i;j<s.length();j++)
            {
                if(contain(s.substring(i,j), s.charAt(j)))
                {
                    j = s.length();
                }else{
                    if(s.substring(i, j).length()>=result)
                    {
                        result = s.substring(i, j).length()+1;
                    }
                }
            }
        }
        return result;
        
    }

    public boolean contain(String s, char ch)
    {
        for(int i = 0; i<s.length();i++)
        {
            if(s.charAt(i)==ch)
            {
                return true;
            }
        }
        return false;
    }
}