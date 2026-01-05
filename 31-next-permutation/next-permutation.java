class Solution {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length-1;
        while(i > 0 && nums[i] <= nums[i-1])
        {
            i--;
        }
        if(i == 0){nums = reverse(nums,0);}
        else
        {  
            int to_swap = nums[i-1];
            int reverse_index = i;
            while(i < nums.length && nums[i] > to_swap) { i++; }
            int next_greater = i-1;
            int temp = nums[reverse_index-1];
            nums[reverse_index-1] = nums[next_greater];
            nums[next_greater] = temp;
            nums = reverse(nums,reverse_index);

        }


    }

    public int[] reverse(int[] arr, int i)
    {
        int start = i;
        int end = arr.length-1;

        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}