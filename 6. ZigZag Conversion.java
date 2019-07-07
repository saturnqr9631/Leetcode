/**
 * Runtime: 15 ms, faster than 66.21% of Java online submissions for ZigZag Conversion.
Memory Usage: 37.6 MB, less than 97.42% of Java online submissions for ZigZag Conversion.
 */
class Solution {
    public String convert(String s, int numRows) 
    {
        if(numRows <= 1)
        {
            return s;
        }
        String[]     stacks      = new String[numRows];
        String       converted   = "";
        int          current_row = 0;
        boolean      reverse     = false;

        for(int i = 0; i<numRows ; i++)
        {
            stacks[i]="";
        }

        for(int i = 0; i<s.length();i++)
        {
            stacks[current_row] +=s.charAt(i);
            if( i !=0 && i %(numRows-1) ==0)
            {
                reverse = !reverse;
            }
            if(reverse)
            {
                current_row--;
            }else{
                current_row++;
            }

        }
        for(int i = 0; i<numRows ; i++)
        {
            converted+=stacks[i];
        }
        return converted;    
    }
}