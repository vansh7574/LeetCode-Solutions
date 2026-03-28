# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import math

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if head.next == None: return head
        if head.next.next == None: return head

        index_to_node = {}
        index = 1
        pointer = head
        while pointer!= None:
             index_to_node[index] = pointer
             next_node = pointer.next
             pointer.next = None
             pointer = next_node
             index+=1
        list_len = index - 1
        mid = math.ceil(list_len/2)     
        p1 = 1
        p2 = 2
        p = list_len
        while p1 != mid:
            node1 = index_to_node.get(p1)
            node2 = index_to_node.get(p2)
            node3 = index_to_node.get(p)
            node1.next = node3
            node3.next = node2
            p1+=1
            p2+=1
            p-=1
        if p1 != p:
           index_to_node.get(p1).next = index_to_node.get(p)     


                
        