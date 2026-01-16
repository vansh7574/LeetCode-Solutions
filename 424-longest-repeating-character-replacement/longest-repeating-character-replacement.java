class Solution {
    public int characterReplacement(String s, int k) {
        if(k == s.length()) return s.length();
        HashMap<Character,Integer> freqTable = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxFreq = 0;
        
        while(end < s.length()){
            char curr = s.charAt(end);
            int count = freqTable.getOrDefault(curr,0);
            freqTable.put(curr, count + 1);
            if(freqTable.get(curr) > maxFreq) maxFreq = freqTable.get(curr);
            int windowSize = end - start + 1;
            
            while(start < end && windowSize - maxFreq > k){
                char currStart = s.charAt(start);
                freqTable.put(currStart, freqTable.get(currStart) - 1);
                start++;
                windowSize = end - start + 1;
            }  
            end++;
        }
        return end - start;
    }
}