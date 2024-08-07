class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] bCount = new int[n];
        int[] aCount = new int[n];
        int minDeletions = Integer.MAX_VALUE;
        if(s.charAt(0) == 'b') bCount[0] = 1;
        if(s.charAt(n-1) == 'a') aCount[n-1] = 1; 
        //1st pass
        int countB = 0;
        for(int i = 0; i < n; i++){
            bCount[i] = countB;
            if(s.charAt(i) == 'b'){
               countB++; 
            }
           
        }
        //2nd pass
        int countA = 0;
        for(int i = n - 1; i >= 0; i--){
            aCount[i] = countA;
            if(s.charAt(i) == 'a'){
                 countA++;
            }
            
        }
        //3rd pass
        for(int i = 0; i < n; i++){
            minDeletions = Math.min(minDeletions, bCount[i] + aCount[i]);
        }
        return minDeletions;
    }
}