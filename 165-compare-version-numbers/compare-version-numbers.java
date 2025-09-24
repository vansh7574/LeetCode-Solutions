class Solution {
    public int compareVersion(String version1, String version2) {
        
    String[] ver1ToStringArr = version1.split("\\.");
    String[] ver2ToStringArr = version2.split("\\.");
    ArrayList<Integer> ver1IntList = new ArrayList();
    ArrayList<Integer> ver2IntList = new ArrayList();
    int limit = -1;
    if (ver1ToStringArr.length > ver2ToStringArr.length)
    {
        limit = ver1ToStringArr.length;
    } 
    else 
    {
        limit = ver2ToStringArr.length;
    }
    
    for(int i = 0; i < limit; i++)
    {
        if(i < ver1ToStringArr.length)
        {
            ver1IntList.add(Integer.parseInt(ver1ToStringArr[i]));
        }
        else{ver1IntList.add(0);}
        if(i < ver2ToStringArr.length)
        {
            ver2IntList.add(Integer.parseInt(ver2ToStringArr[i]));
        }
        else{ver2IntList.add(0);}
    }

    for(int i = 0; i < ver1IntList.size(); i++)
    {
        int rev1 = ver1IntList.get(i);
        int rev2 = ver2IntList.get(i);
        if (rev1 < rev2)
        {
            return -1;
        }
        else if (rev1 > rev2)
        {
            return 1;
        }
    }

    return 0;
}
}