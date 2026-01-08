class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

        maxSubArr = nums[0]
        currSubArr = nums[0]
        for i in range(1,len(nums)):
            currSubArr = max(nums[i], currSubArr + nums[i])
            maxSubArr = max(maxSubArr, currSubArr)    
        return maxSubArr