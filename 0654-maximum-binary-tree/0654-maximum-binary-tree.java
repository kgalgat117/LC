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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
                Deque<TreeNode> stack = new LinkedList<>();
        for(int n : nums){
            TreeNode cur = new TreeNode(n);
            while(!stack.isEmpty() && stack.peek().val < n){
                cur.left = stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}