class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        right_max = [None] * len(prices)
        right_max[len(prices) - 1] = prices[len(prices) - 1]
        
        for i in range(len(prices) - 2, -1, -1):
            right_max[i] = max(prices[i], right_max[i+1]) 
        
        max_profit = 0
        for i in range(0,len(prices)):
            max_profit = max(max_profit, right_max[i] - prices[i])

        return max_profit     



