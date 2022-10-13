/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function(root) {
    return check(root)[0];
};

const check = (root) => {
    if (!root) return [0,0];
    
    let left = check(root.left);
    let right = check(root.right);
    
    let path = left[1] + right[1];
    let diameter = Math.max(left[0], right[0]);
    let maxDiameter = Math.max(path, diameter);
    let height = 1 + Math.max(left[1], right[1]);
    
    return [maxDiameter, height];
}