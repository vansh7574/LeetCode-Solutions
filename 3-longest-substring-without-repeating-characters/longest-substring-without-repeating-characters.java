class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> seen = new HashSet<Character>();
        int windowstart = 0;
        int max = Integer.MIN_VALUE;
        
        for(int windowend = 0; windowend < s.length(); windowend++){
               if(seen.contains(s.charAt(windowend)) == false ){
                   seen.add(s.charAt(windowend)); 
                 }
               else{
                    while(seen.contains(s.charAt(windowend)) && windowend - windowstart >= 1){
                         seen.remove(s.charAt(windowstart));  
                         windowstart++;  
                     }
                   seen.add(s.charAt(windowend));
               }
               max = Math.max(windowend - windowstart + 1, max);             
        }
        if (max == Integer.MIN_VALUE){return 0;}
        return max;
    }      
}
       

        
