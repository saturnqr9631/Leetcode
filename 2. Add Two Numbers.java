/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Runtime: 2 ms, faster than 95.07% of Java online submissions for Add Two Numbers.
Memory Usage: 43.4 MB, less than 64.10% of Java online submissions for Add Two Numbers.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode result = null;
        ListNode tempResult = result;
        int      flag = 0;
        int      length1 = 0;
        int      length2 = 0;
        int      maxLength = 0;
        while(temp1 !=null)
        {
            length1++;
            temp1 = temp1.next;
        }
        while(temp2 !=null)
        {
            length2++;
            temp2 = temp2.next;
        }
        if(length1<length2)
        {
           
            maxLength = length1;
            result = new ListNode(l2.val);
            temp2 =l2;
            tempResult = result;
            while(temp2.next !=null)
            {
                tempResult.next = new ListNode(temp2.next.val);
                tempResult =tempResult.next;
                temp2 =temp2.next;
            }
        }else{
            maxLength = length2;
            result = new ListNode(l1.val);
            temp1 =l1;
            tempResult = result;
            while(temp1.next !=null)
            {
                tempResult.next = new ListNode(temp1.next.val);
                tempResult =tempResult.next;
                temp1 =temp1.next;
            }
        }
        temp1 = l1;
        temp2 = l2;
        tempResult = result;
        for(int i = 0; i<maxLength; i++)
        {
            int sum =temp1.val+temp2.val+flag;
            tempResult.val = sum;
            tempResult = tempResult.next;
            temp1 =temp1.next;
            temp2 = temp2.next;
        }
        tempResult = result;
        while(tempResult !=null)
        {
            int sum = tempResult.val+flag;
            if(sum>=10)
            {
                tempResult.val =sum % 10;
                flag = 1;
            }else{
                tempResult.val = sum;
                flag = 0;
            }
            if(tempResult.next ==null && flag ==1)
            {
                tempResult.next =new ListNode(1);
                flag =0;
            }
            tempResult = tempResult.next;
        }
        
        return result;
    }
}