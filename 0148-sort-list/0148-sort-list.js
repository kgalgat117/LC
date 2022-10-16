/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    
    if (!head || !head.next) return head;
    
    let slow = head;
    let fast = head;
    
    while (fast.next && fast.next.next) {
        fast = fast.next.next;
        slow = slow.next;
    }
    
    let middle = slow.next;
    slow.next = null;
    
    let temp = new ListNode(null);
//     using merge sort on linkedlist. making recursive calls
    return merge(temp, sortList(head), sortList(middle));
    
};

const merge = (root, left, right) => {
    let pointer = root;
    
    while (left !== null || right !== null) {
        if (left == null) {
            pointer.next = right;
            right = right.next;
        } else if (right == null) {
            pointer.next = left;
            left = left.next;
        } else {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
        }
        pointer = pointer.next;
    }
    return root.next;
}