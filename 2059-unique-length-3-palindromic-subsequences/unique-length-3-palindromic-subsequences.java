class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        HashMap<Character, List<Integer>> bounds = new HashMap<>();
        int res = 0;
        for(char c : s.toCharArray()) uniqueChars.add(c);
        
        for(char c : uniqueChars){
            int low = -1;
            int high = 0;
            bounds.put(c, new ArrayList<>());
            for(int i = 0; i < s.length(); i++) 
            {
                if(c == s.charAt(i) && low == -1)
                {
                    low = i;
                }
                else if(c == s.charAt(i)){
                    high = i;
                }    
            }
            bounds.get(c).add(low);
            bounds.get(c).add(high);
        }

        
        for(Map.Entry<Character,List<Integer>> entry:bounds.entrySet())
        {
            int low = entry.getValue().get(0);
            int high = entry.getValue().get(1);
            uniqueChars.clear();
            for(int i = low + 1; i <= high - 1; i++)
            {
               uniqueChars.add(s.charAt(i));     
            }
            res += uniqueChars.size();
        }

        return res;

    }
}