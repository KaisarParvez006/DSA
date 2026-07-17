class Solution {
    public int findGCD(int[] nums) {
        int size = nums.length;
 int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        return gcd(min, max);
    }
    static int gcd(int a, int b){
        while(b != 0){
            int rem = a%b;
            a = b;
            b = rem;
        }
        return a;
    }
}








/*
for every elemnt in array 
class Solution {
    public int findGCD(int[] nums) {
        int size = nums.length;
        int ans = nums[0];
        for(int i = 1; i < size; i++){
            ans = gcd(ans, nums[i]);
        }
        return ans;
    }
    static int gcd(int a, int b){
        while(b != 0){
            int rem = a%b;
            a = b;
            b = rem;
        }
        return a;
    }
}
*/