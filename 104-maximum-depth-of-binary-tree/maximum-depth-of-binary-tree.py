# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        maxi = 0
        
        def depth(node, dep):
            if node == None: return
            nonlocal maxi
            maxi = max(dep, maxi)
            depth(node.left,dep + 1)
            depth(node.right,dep + 1)

        depth(root,1)  
        return maxi  
            
        