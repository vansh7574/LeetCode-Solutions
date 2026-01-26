class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stk = new ArrayList<>();
        
        stk.add(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++){
            int currNum = asteroids[i];
            
            if(stk.size() > 0 && stk.get(stk.size()-1) > 0 && currNum < 0){
                while(stk.size() > 0 && stk.get(stk.size()-1) > 0 && stk.get(stk.size()-1) < Math.abs(currNum)){
                    stk.remove(stk.size()-1);
                }
                
            }
            if(stk.size() != 0 && stk.get(stk.size()-1) > 0 && currNum < 0 && stk.get(stk.size()-1) == Math.abs(currNum)) stk.remove(stk.size()-1);
            else if(stk.size() != 0 && stk.get(stk.size()-1) > 0 && currNum > 0) stk.add(currNum); 
            else if(stk.size() != 0 && stk.get(stk.size()-1) < 0 && currNum < 0) stk.add(currNum); 
            else if(stk.size() != 0 && stk.get(stk.size()-1) < 0 && currNum > 0) stk.add(currNum);
            else if(stk.size() == 0) stk.add(currNum);
        }
        int[] res = new int[stk.size()];
        int poi = 0;
        for(int i : stk){
            res[poi++] = i;
        }
        return res;     
    }
}