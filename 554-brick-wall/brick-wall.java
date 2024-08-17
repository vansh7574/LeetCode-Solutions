class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        boolean allSizeOne = true;
        for(List<Integer> row : wall){
            if(row.size() > 1) allSizeOne = false;
        }
        if(allSizeOne) return wall.size();

        HashMap<Integer,Integer> widths = new HashMap<>();

        for(List<Integer> row : wall){
            int currWidth = 0;
            for(int i = 0; i < row.size() - 1; i++){
                currWidth += row.get(i);
                if(widths.containsKey(currWidth))
                {
                    widths.put(currWidth, widths.get(currWidth) + 1);
                }
                else
                {
                    widths.put(currWidth, 1);    
                }
            }
        }
        int max = -1;
        for(Map.Entry<Integer,Integer> entry: widths.entrySet())
        {
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }
}