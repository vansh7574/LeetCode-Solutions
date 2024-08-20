class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] memo = new int[n+1][n / 2 + 1];
        return 1 + helper(1,1,n,memo);
        
    }

    int helper(int currLen, int copiedLen, int n, int[][] memo)
    {
        if(currLen == n)
        {
            return 0;
        }
        if(currLen > n)
        {
            return 1000;
        }
        if(memo[currLen][copiedLen] != 0 ){
            return memo[currLen][copiedLen]; 
        }
        
        int op2 = 1 + helper(currLen + copiedLen, copiedLen, n, memo);
        int op1 = 2 + helper(currLen * 2, currLen, n, memo);
        
        memo[currLen][copiedLen] = Math.min(op1, op2); 
        return memo[currLen][copiedLen];
    }
}