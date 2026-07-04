//check placement notes

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int s1 = 0, s2 = 0;
        int s = 0;
        for(int i = 0; i < gas.length; i++){
            s1 = s1 + gas[i];
        }
        for(int i = 0; i < cost.length; i++){
            s2 = s2 + cost[i];
        }

        if(s1 < s2)
            return -1;
        

        for(int i = 0; i < gas.length; i++){
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                s = i+1;
            }
        }
        return s;
    }
}