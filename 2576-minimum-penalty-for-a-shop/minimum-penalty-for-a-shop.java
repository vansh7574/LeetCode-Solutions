class Solution {
    public int bestClosingTime(String customers) {
        int totalYes = 0;
        int totalNo = 0;
        int[] left = new int[2];
        int[] right = new int[2];
        int counter = 0;
        int len = customers.length();
        int minPenalty = Integer.MAX_VALUE;
        int hour = -1;
        for(int i = 0; i < len; i++){
             if(customers.charAt(i) == 'Y') totalYes++;
             else totalNo++;   
        }
        right[0] = totalYes;
        right[1] = totalNo;
        int leftPenalty = -1;
        int rightPenalty = -1;
        int currPenalty = 0;
        while(counter < len){
            
            
            leftPenalty = left[1];
            rightPenalty = right[0];
                
            
            currPenalty = leftPenalty + rightPenalty;
            //minPenalty = Math.min(minPenalty, currPenalty);
            if(currPenalty < minPenalty){
                minPenalty = currPenalty;
                hour = counter; 
            }
            if(customers.charAt(counter) == 'Y'){
                right[0]--;
                left[0]++; 
            }
            else{
                right[1]--;
                left[1]++;
            }
            counter++; 
        }
        leftPenalty = left[1];
        rightPenalty = right[0];
        currPenalty = leftPenalty + rightPenalty;
        if(currPenalty < minPenalty){
            minPenalty = currPenalty;
            hour = counter; 
        }
        return hour;
    }
}