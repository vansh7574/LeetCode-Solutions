class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        long klong = k;
        System.out.println(chalk.length);
        for(int i = 0; i < chalk.length; i++){
            sum += chalk[i];
        }
        if(sum <= klong){
            while(klong >= sum){ klong-= sum;}
        }
        
        if(klong == 0) return 0;
        int studentNum = -1;
        for(int i = 0; i < chalk.length; i++){
            if(klong >= chalk[i]){
                klong -= chalk[i];
            }
            else{
                studentNum = i;
                break;
            }
        }
        return studentNum;
    }
}