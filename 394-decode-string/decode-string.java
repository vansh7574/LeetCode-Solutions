class Solution {
    public String decodeString(String s) {
        ArrayDeque<Character> stk = new ArrayDeque<>();
        char[] sToArray = s.toCharArray();
        //int len 
        for(char c : sToArray){
                if(c != ']'){
                    stk.addLast(c);
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    while(stk.getLast()!='['){
                          sb.append(stk.removeLast());  
                    }
                    stk.removeLast();
                    
                    StringBuilder k = new StringBuilder();
                    while(stk.size()!=0 && Character.isDigit(stk.getLast())){
                         k.append(stk.removeLast());   
                    }
                    int numTimes = Integer.parseInt(k.reverse().toString());
                    
                    StringBuilder sb2 = new StringBuilder(sb);
                    for(int i = 0; i < numTimes-1; i++){sb = sb.append(sb2);}
                    char[] cArray = sb.reverse().toString().toCharArray();
                    List<Character> lst = new ArrayList<>();
                    for(char cc : cArray){
                        lst.add(cc);
                    }
                    stk.addAll(lst);
                }
        }
         StringBuilder sb = new StringBuilder();
         while(stk.size()!=0){
            sb.append(stk.removeLast());    
         }

         return sb.reverse().toString();

    }
}