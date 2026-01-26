class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        for brace in s:
            if brace == "(" or brace == "[" or brace == "{":
                stk.append(brace)
            elif brace == ")" and len(stk) > 0 and stk[len(stk) - 1] == "(":
                stk.pop(len(stk) - 1)
            elif brace == "]" and len(stk) > 0 and stk[len(stk) - 1] == "[":
                stk.pop(len(stk) - 1)
            elif brace == "}" and len(stk) > 0 and stk[len(stk) - 1] == "{": 
                stk.pop(len(stk) - 1) 
            else: stk.append(brace)
        return len(stk) == 0                 