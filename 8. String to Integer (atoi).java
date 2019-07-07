/**Runtime: 3 ms, faster than 65.37% of Java online submissions for String to Integer (atoi).
Memory Usage: 34.9 MB, less than 99.98% of Java online submissions for String to Integer (atoi). */
class Solution {
    public int myAtoi(String str) 
    {
        int converted = 0;
        int pow      = 0;
        int temp_pow = 0;
        boolean negative = false;
        str = str.trim();
        if(str.length() == 0 )
        {
            return 0;
        }
        char pos =str.charAt(0);
        if(pos == '-' || pos == '+')
        {
            if(pos == '-')
            {
                negative = true;
            }
            if(str.length()==1)
            {
                return 0;
            }
            str = str.substring(1);
            
        }else if( pos <'0' || pos >'9')
        {
            return 0;
        }
        str = removeZero(str);
        if(str.length()>0)
        {
            pow = find_pow(str);
            temp_pow = pow;
        }else{
            return 0;
        }
        
        for(int i = 0; i <str.length();i++)
        {
            pos = str.charAt(i);
            
            if(pos <= '9' && pos >= '0')
            {
                int converted_pos =  pos - 48;
                converted += Math.pow(10, pow-1)*converted_pos;
                if(pow != 1)
                {
                    if(converted >=2147483647)
                    {
                         if(negative)
                         {
                            converted =-2147483648;
                            return  converted;
                         }else{
                            return  2147483647;
                         }
                    }
                }
                pow--;
            }else{
                if(converted >=2147483647)
                    {
                        if(negative && str.charAt(temp_pow-1) !='7')
                        {
                            converted =-2147483648;
                            return  converted;
                        }else if(negative){
                            return converted =converted*-1;
                        }else{
                            return  2147483647;
                        }
                    }
                if(negative)
                {
                    converted =converted*-1;
                }
                return converted;
            }
        }
        if(converted >=2147483647)
        {
            if(negative && str.charAt(temp_pow-1) !='7')
            {
                converted =-2147483648;
                return  converted;
            }else if(negative){
                return converted =converted*-1;
            }else{
                return  2147483647;
            }
        }
        if(negative)
        {
            converted =converted*-1;
        }
        
        return converted;
    }

    public String removeZero(String str) 
    { 
        // Count leading zeros 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
  
        // Convert str into StringBuffer as Strings 
        // are immutable. 
        StringBuffer sb = new StringBuffer(str); 
  
        // The  StringBuffer replace function removes 
        // i characters from given index (0 here) 
        sb.replace(0, i, ""); 
  
        return sb.toString();  // return in String 
    } 

    public int find_pow(String str)
    {
        char ch  = str.charAt(0);
        int  pow = 0;
        int  i   = 0;
        while(ch <= '9' && ch >= '0' && i<str.length())
        {
            ch = str.charAt(i);
            pow++;
            i++;
        }
        if(ch < '0' || ch > '9')
        {
            pow--;
        }
        return pow;
    }
}