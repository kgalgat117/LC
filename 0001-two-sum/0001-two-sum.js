/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let memory = {}
    for (let index=0;index<nums.length;index++) {
        let complement = target - nums[index];
        if(memory[complement]) {
            return [memory[complement], index];
        }
        memory[nums[index]] = index + "";
    }
    return [-1, -1];
};