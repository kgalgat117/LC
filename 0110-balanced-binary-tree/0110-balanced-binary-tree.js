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
 * @return {boolean}
 */
var isBalanced = function(root) {
    return check(root)[0];
};

const check = (root) => {
    
    if (!root) return [true, 0];

    let left = check(root.left);
    let right = check(root.right);
    
    if (!left[0] || !right[0]) return [false];
    
    let diff = Math.abs(left[1] - right[1]);
    
    if (diff < 2) {
        return [true, Math.max(left[1], right[1]) + 1];
    } else {
        return [false];
    }
}