class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || k <= 0) return new int [0];
    int [] arr = new int[nums.length - k + 1];
    int in = 0;
    Deque<Integer> dq = new ArrayDeque<>();
    for(int i = 0; i < nums.length; i++){
        while(!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
        dq.offer(i);
        if(i >= k - 1) arr[in++] = nums[dq.peek()];
    }
    return arr;
    }



   // PQ solution 
//     // Use indices since they are unique
// public int[] maxSlidingWindow(int[] nums, int k) {
//   // assume nums is not null
//   if (nums.length == 0 || k == 0) {
//     return new int[0];
//   }
//   int n = nums.length;
//   int[] result = new int[n - k + 1]; // number of windows
  
//   PriorityQueue<Integer> maxPQ = new PriorityQueue<>((i1, i2) -> (nums[i2] - nums[i1])); // stores values
  
//   for (int i = 0; i < n; ++i) {
//     int start = i - k;
//     if (start >= 0) {
//       maxPQ.remove(start); // remove the out-of-bound value by index
//     }
//     maxPQ.offer(i);
//     if (maxPQ.size() == k) {
//       result[i - k + 1] = nums[maxPQ.peek()];
//     }
//   }
//   return result;
// }
    

}


