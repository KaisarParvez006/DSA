class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //map.put / map.get / map.containsKey // key = 2, value = 0
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{
            map.get(need),i
             };
          }
            else{
            map.put(nums[i], i);
        }
    }
    return new int[]{};
   }
}


