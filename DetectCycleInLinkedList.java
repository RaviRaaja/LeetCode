/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// floyd Cycle detection algorithm

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        
        while(slow!=null && fast!=null && fast.next!=null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                flag = 1;
                break;
            }
            
        }
        
        return (flag == 0)? null: finfMeetingPoint(head, slow, fast);
    }
    
    public ListNode finfMeetingPoint(ListNode head, ListNode slow, ListNode fast) {
        slow = head;
        while( slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}

// Solution using HashSet

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        Set<ListNode> hs = new HashSet<>();
        
        
        ListNode curr = head;
        
        while(curr!=null) {
            
            if(hs.contains(curr)) {
                return curr;
            } else {
                hs.add(curr);
            }
            
            curr = curr.next;
        }
        
        return null;
    }
}
