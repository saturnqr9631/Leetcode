/**Runtime: 8 ms, faster than 75.85% of Java online submissions for Palindrome Number.
Memory Usage: 35 MB, less than 75.99% of Java online submissions for Palindrome Number. */
class Solution {
    public boolean isPalindrome(int x) 
    {
        String str =   Integer.toString(x);
        for(int i =0; i< str.length() ;i++)
        {
            if(str.charAt(i) != str.charAt(str.length()-i-1))
            {
                return false;
            }
        }
        return true;

    }
}