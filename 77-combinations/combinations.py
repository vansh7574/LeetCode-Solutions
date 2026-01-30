class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        res = []
        def backtrack(curr_k, comb, start):
            if curr_k == 0:
                res.append(list(comb)) 
                return

            for i in range(start, n+1):
                comb.append(i)
                backtrack(curr_k - 1, comb, i + 1)
                comb.pop(-1)

        backtrack(k, [], 1)
        return res