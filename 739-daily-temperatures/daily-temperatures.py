class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        ans = [0] * n
        stk = []
        stk.append(0)
        for i in range(1,n):
            curr_num = temperatures[i]
            while len(stk) != 0 and temperatures[stk[-1]] < curr_num:
                popped = stk.pop()
                ans[popped] = i - popped 
            stk.append(i)  
        if len(stk) != 0:
            while len(stk) != 0:
                ans[stk.pop()] = 0
                      
        return ans        

