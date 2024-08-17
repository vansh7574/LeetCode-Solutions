class Solution {
    public String numberToWords(int num) {
        String stringNum = String.valueOf(num);
        ArrayList<String> tempList = new ArrayList<>();
        String finalRes = "";
        String hundred = "Hundred";
        String thousand = "Thousand";
        String million = "Million";
        String billion = "Billion";

        HashMap<String,String> numToWord = new HashMap<>();
        HashMap<String,String> numToWord2 = new HashMap<>();
        numToWord.put("0","Zero");
        numToWord.put("1","One");
        numToWord.put("01","One");
        numToWord.put("2","Two");
        numToWord.put("02","Two");
        numToWord.put("3","Three");
        numToWord.put("03","Three");
        numToWord.put("4","Four");
        numToWord.put("04","Four");
        numToWord.put("5","Five");
        numToWord.put("05","Five");
        numToWord.put("6","Six");
        numToWord.put("06","Six");
        numToWord.put("7","Seven");
        numToWord.put("07","Seven");
        numToWord.put("8","Eight");
        numToWord.put("08","Eight");
        numToWord.put("9","Nine");
        numToWord.put("09","Nine");
        numToWord.put("10","Ten");
        numToWord.put("11","Eleven");
        numToWord.put("12","Twelve");
        numToWord.put("13","Thirteen");
        numToWord.put("14","Fourteen");
        numToWord.put("15","Fifteen");
        numToWord.put("16","Sixteen");
        numToWord.put("17","Seventeen");
        numToWord.put("18","Eighteen");
        numToWord.put("19","Nineteen");
        
        //Tens
        numToWord2.put("2","Twenty");
        numToWord2.put("20","Twenty");
        numToWord2.put("3","Thirty");
        numToWord2.put("30","Thirty");
        numToWord2.put("4","Forty");
        numToWord2.put("40","Forty");
        numToWord2.put("5","Fifty");
        numToWord2.put("50","Fifty");
        numToWord2.put("6","Sixty");
        numToWord2.put("60","Sixty");
        numToWord2.put("7","Seventy");
        numToWord2.put("70","Seventy");
        numToWord2.put("8","Eighty");
        numToWord2.put("80","Eighty");
        numToWord2.put("9","Ninety");
        numToWord2.put("90","Ninety");
        
        if(stringNum.length() == 1) return numToWord.get(stringNum);    
        if(stringNum.length() == 2)
        {   
            return twoDigits(stringNum, numToWord, numToWord2);
        }
        
        int end = stringNum.length();
        while(end > 0){
            int start = Math.max(end - 3, 0);
            String num2 = stringNum.substring(start, end);
            tempList.add(0,num2);
            end = start;
        }

        for(int i = tempList.size()-1; i >=0; i--)
        {   
            String resTemp = "";
            String subNum = tempList.get(i);
            if(subNum.length() == 3 && !subNum.equals("000")){
                String temp = "";
                if(subNum.charAt(0) != '0') temp = numToWord.get(String.valueOf(subNum.charAt(0))) + " " + hundred;
                String temp2 = twoDigits(subNum.substring(1,3), numToWord, numToWord2);
                if(!temp.isEmpty() && !temp2.isEmpty()) resTemp = temp + " " + temp2;
                else if(temp.isEmpty()) resTemp = temp2;
                else if(temp2.isEmpty()) resTemp = temp;
            }
            else if(subNum.length() == 2){
                resTemp = twoDigits(subNum, numToWord, numToWord2);
            }
            else if(subNum.length() == 1){

                resTemp = numToWord.get(subNum);
            }
            
            tempList.set(i,resTemp);    
        }
        
        if(tempList.size() == 4)
        {   
            if(tempList.get(1).isEmpty() && tempList.get(2).isEmpty() && tempList.get(3).isEmpty()){ finalRes = tempList.get(0) + " " + billion;}
            else if(tempList.get(1).isEmpty() && tempList.get(2).isEmpty() && !tempList.get(3).isEmpty()){
                finalRes = tempList.get(0) + " " + billion + " " + tempList.get(3);
            }
            else if(tempList.get(2).isEmpty() && tempList.get(3).isEmpty()){
                finalRes = tempList.get(0) + " " + billion + " " + tempList.get(1) + " " + million;
            }
            else{
                finalRes = tempList.get(0) + " " + billion + " " + tempList.get(1) + " " + million + " " + tempList.get(2) + " " + thousand + " " + tempList.get(3);
            }
        }
        else if(tempList.size() == 3)
        {   
            if(tempList.get(1).isEmpty() && tempList.get(2).isEmpty())
            {
                finalRes = tempList.get(0) + " " + million;
            }
            else if(tempList.get(1).isEmpty() && !tempList.get(2).isEmpty())
            {
                finalRes = tempList.get(0) + " " + million + " " + tempList.get(2);
            }
            else{
                finalRes = tempList.get(0) + " " + million + " " + tempList.get(1) + " " 
            + thousand + " " + tempList.get(2);
            }
        }
        else if(tempList.size() == 2)
        {
            finalRes = tempList.get(0) + " " + thousand + " " + tempList.get(1);
        }
        else if(tempList.size() == 1){
            finalRes = tempList.get(0);
        }
        
        return finalRes.strip();

    }
    String twoDigits(String num , HashMap<String,String> numToWord, HashMap<String,String> numToWord2)
    {       
            if(num.equals("00")){
                return"";
            }    
            if(numToWord.containsKey(num)){
                return numToWord.get(num);
            }
            if(numToWord2.containsKey(num)){
                return numToWord2.get(num);    
            }

            String res = "";
            String tens = String.valueOf(num.charAt(0));
            String ones = String.valueOf(num.charAt(1));
            res = numToWord2.get(tens) + " " + numToWord.get(ones);
            return res;
    }
}