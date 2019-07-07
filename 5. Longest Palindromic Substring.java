/**
 * Runtime: 603 ms, faster than 8.82% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 36.1 MB, less than 96.40% of Java online submissions for Longest Palindromic Substring.

 */
class Solution
{
    public String longestPalindrome(String s)
    {
        String maxSub = "";
        if(sameChar(s))
        {
            return s;
        }
        
        for(int i=0; i<s.length();i++)
        {
                for(int j =i;j<=s.length();j++)
                {
                    String tempSub = s.substring(i, j);
                   if(isPalindormic(tempSub))
                    {
                        if(tempSub.length()>maxSub.length())
                        {
                            maxSub = tempSub;
                        }
                    }
                    
                }
        }
        return maxSub;
    }
    public boolean isPalindormic(String s)
    {
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) != s.charAt(s.length()-i-1))
            {
                return false;
            }
        }
        return true;
    }
    public boolean sameChar(String s)
    {
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)!=s.charAt(i+1))
            {
                 return false;
            }
        }
        return true;
    }
}