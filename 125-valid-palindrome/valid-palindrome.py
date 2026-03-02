class Solution:
    def isPalindrome(self, s: str) -> bool:
        converted = ""
        for i in range(0,len(s)):
            if s[i].isalpha() or s[i].isalnum():
                converted+=s[i]
        if converted == "": return True
        converted = converted.casefold()
        start = 0
        end = len(converted) - 1
        print(converted)
        while start < end:
            if converted[start] != converted[end]:
                return False
            start+=1
            end-=1      
        return True        
