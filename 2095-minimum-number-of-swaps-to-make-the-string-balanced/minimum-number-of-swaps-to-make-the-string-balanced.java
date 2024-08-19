class Solution {
    public int minSwaps(String s) {
        int closingBracs = 0;
        int maxClosing = 0;
        for(char c : s.toCharArray()){
            if(c == ']'){
                closingBracs++;
                maxClosing = Math.max(maxClosing, closingBracs);
            }
            else{
                closingBracs--;
            }
        }
        if(maxClosing % 2 == 0){
            return maxClosing/2;
        }
        return (maxClosing+1)/2;
    }
}