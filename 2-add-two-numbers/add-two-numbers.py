# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1_pointer = l1
        l2_pointer = l2
        carry = 0    
        res_head = ListNode()
        res_pointer = res_head
        while l1_pointer!= None or l2_pointer != None:
            x = l1_pointer.val if l1_pointer != None else 0
            y = l2_pointer.val if l2_pointer != None else 0
            summ = x + y + carry
            carry = summ // 10
            node_val = summ % 10
            res_pointer.val = node_val
            if (l1_pointer != None and l1_pointer.next != None) or (l2_pointer != None and l2_pointer.next != None):
                res_pointer.next = ListNode()
                res_pointer = res_pointer.next
            if l1_pointer!= None: l1_pointer = l1_pointer.next 
            if l2_pointer!=None: l2_pointer = l2_pointer.next
        if carry == 1:
            res_pointer.next = ListNode()
            res_pointer.next.val = 1
        return res_head           

        