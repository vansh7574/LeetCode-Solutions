/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          if (preorder.length==0 && inorder.length==0) return null;
          if (preorder.length==1 && inorder.length==1) return new TreeNode(preorder[0]);
          HashMap<Integer,Integer> preIndex = new HashMap<>();
          HashMap<Integer,Integer> inIndex = new HashMap<>();  
          int len = preorder.length;
          for(int i = 0; i < preorder.length;i++){
              preIndex.put(preorder[i],i);
              inIndex.put(inorder[i],i);
          }

          TreeNode root = new TreeNode(preorder[0]);
          int inorderInd = inIndex.get(preorder[0]);
          int[] preLeftSubtree = Arrays.copyOfRange(preorder,1,inorderInd+1);
          int[] inLeftSubtree = Arrays.copyOfRange(inorder,0,inorderInd);
          int[] prerightSubtree = Arrays.copyOfRange(preorder,inorderInd+1, len);
          int[] inrightSubtree = Arrays.copyOfRange(inorder,inorderInd + 1, len);

          root.left =  buildTree(preLeftSubtree,inLeftSubtree);
          root.right = buildTree(prerightSubtree,inrightSubtree);
          return root;  
    }
    
}