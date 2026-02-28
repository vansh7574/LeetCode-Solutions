class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        majority = len(nums) // 2
        majority+=1
        frequency = {}
        for i in range(0,len(nums)):
            if frequency.get(nums[i]) == None:
                frequency[nums[i]] = 1
            else: frequency[nums[i]] = frequency[nums[i]] + 1
            if frequency.get(nums[i]) == majority:
                return nums[i]
        
