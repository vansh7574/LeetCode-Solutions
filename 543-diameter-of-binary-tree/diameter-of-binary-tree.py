# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:

        maxi = 0
        def diameter(node):
            if node == None: return 0
            nonlocal maxi
            left = diameter(node.left)
            right = diameter(node.right)
            maxi = max(left + right, maxi)
            return 1 + max(left,right)

        diameter(root)
        return maxi    
                
        