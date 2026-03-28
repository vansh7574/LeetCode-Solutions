class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        if k == len(nums): return k
        num_ones = 0
        num_zeros = 0
        end = 0
        start = 0
        max_ones = 0

        for i in nums:
            if i == 1:
                num_ones += 1
        if num_ones == 0 and k == 0:
            return 0
        elif num_ones == 0 and k > 0:
             return k    

        num_ones = 0            

        while end < len(nums):
            
            if nums[end] == 1:
                    num_ones += 1
            elif nums[end] == 0:
                    num_zeros += 1


            while end > start and (end - start + 1) - num_ones > k:
                
                if nums[start] == 1:
                    num_ones -= 1
                elif nums[start] == 0:
                    num_zeros -= 1

                start+=1

            
            max_ones = max(end - start + 1, max_ones)
            end+=1
                    

        return max_ones

        