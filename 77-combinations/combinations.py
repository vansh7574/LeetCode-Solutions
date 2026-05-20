class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        if n == k:
            temp = [i for i in range(1,n+1)]
            res.append(temp)
            return res
            
        def dfs(i, curr_size, curr_comb):
            
            if i > n+1:
                return
            if curr_size > k:
                return
            if curr_size == k:
                res.append(curr_comb.copy())
                return

            curr_comb.append(i)
            #for num in range(i+1, n+1):
            dfs(i+1, curr_size + 1, curr_comb)
            curr_comb.pop()
            dfs(i+1, curr_size, curr_comb)              

        dfs(1,0,[])
        return res        
            


