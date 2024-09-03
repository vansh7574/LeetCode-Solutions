class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] memo = new long[nums.length][2];
        for(long[] arr : memo){
            Arrays.fill(arr, -1);
        }
        return dfs(nums, 0, 0, memo);
    }

    public long dfs(int[] nums, int index, int even, long[][] memo){
        if(index == nums.length) return 0;
        if(memo[index][even] != -1 ) return memo[index][even];

        long total = -1;
        if(even == 0) total = nums[index];
        else total = -1 * nums[index];
        int var = even == 0 ? 1 : 0;
        memo[index][even] = Math.max(total + dfs(nums, index + 1, var, memo), dfs(nums, index + 1, even, memo));
        return memo[index][even];
    }
}