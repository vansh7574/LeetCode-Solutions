class Solution:
    def calPoints(self, operations: List[str]) -> int:
         stk = []
         sum = 0
         for opr in operations:
             if opr.lstrip("+-").isdecimal():
                curr_num = int(opr)
                stk.append(curr_num)
             elif opr == "C":
                stk.pop(len(stk)-1) 
             elif opr == "D":
                stk.append(stk[(len(stk)-1)] * 2)
             elif opr == "+":  
                stk.append(stk[(len(stk)-1)] + stk[(len(stk)-2)])   

         for num in stk:
             sum+=num

         return sum       
        