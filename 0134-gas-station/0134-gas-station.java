class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int shortage = 0;
        int tank = 0;
        int start = 0;
        
        for (int i=0;i<gas.length;i++){
            
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                shortage += tank;
                tank = 0;
                start = i + 1;
            }
        }
        
        return shortage + tank >= 0 ? start : -1;
    }
}