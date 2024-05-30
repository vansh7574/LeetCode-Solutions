class UndergroundSystem {

    HashMap<Integer, List<String>> checkIn;
    HashMap<String, List<Integer>> checkOut;
    
    public UndergroundSystem() 
    {
         checkIn = new HashMap<>();
         checkOut = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) 
    {
         if(checkIn.containsKey(stationName) == false)
         {
            checkIn.put(id, new ArrayList<String>());
         }
         checkIn.get(id).add(stationName);
         checkIn.get(id).add(String.valueOf(t));   
    }
    
    public void checkOut(int id, String stationName, int t) 
    {
        if(checkIn.containsKey(id) == true)
         {
            //checkOut.put(stationName, new ArrayList<Integer>());
            String startStation = checkIn.get(id).get(0);
            String pair = startStation + "-" + stationName;
            String cInTime = checkIn.get(id).get(1);
            int dist = t - Integer.valueOf(cInTime);
            
            if(checkOut.containsKey(pair) == false){
                checkOut.put(pair, new ArrayList<>());
            } 
            checkOut.get(pair).add(dist);
         }
         //checkOut.get(stationName).add(t);   
    }
    
    public double getAverageTime(String startStation, String endStation) 
    {
        //List<Integer> cInTimes = checkIn.get(startStation); 
        String pair = startStation + "-" + endStation;
        List<Integer> cOuTimes = checkOut.get(pair);
        //int minsize = Math.min(cInTimes.size(),cOuTimes.size());
        int sum  = 0;
        for(int i = 0; i < cOuTimes.size(); i++)
        {
            sum += cOuTimes.get(i);
        }
        return Double.valueOf(sum)/Double.valueOf(cOuTimes.size());
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */