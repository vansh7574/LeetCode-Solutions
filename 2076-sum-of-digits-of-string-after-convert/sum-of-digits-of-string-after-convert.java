class Solution {
    public int getLucky(String s, int k) {
        String temp = "";
        int counter = 0;
        for(char c : s.toCharArray()){
            temp += String.valueOf(c - 97 + 1);
        }
        int currNum = 0;
        while(counter < k){
             currNum = 0;
             for(char c : temp.toCharArray()){
                currNum += (c - 48);
            }  
            temp = String.valueOf(currNum); 
            
            counter++;
        }  
        return currNum;  
    }
}