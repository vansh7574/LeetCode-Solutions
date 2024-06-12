class Solution {
    public void sortColors(int[] nums) {
       int start = 0;
       int end = nums.length-1;
       int[] temp = new int[]{0,0};
       for(int i = 0; i < nums.length;i++){
           if(nums[i] == 0) temp[0] += 1;
           else if(nums[i] == 1) temp[1] += 1;
       } 
       for(int i = 0; i < nums.length;i++){
           if(temp[0] != 0) {
               nums[i] = 0;
               temp[0] -= 1;
           }
           else if(temp[1] != 0){
               nums[i] = 1;
               temp[1] -= 1; 
           }
           else nums[i] = 2;
       }
    }
}