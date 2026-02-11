class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        dupes = set()
        start = 0
        end = 0 
        max_size = 0
        while end < len(s):

            while len(dupes)!=0 and s[end] in dupes:
                dupes.remove(s[start])
                start+=1

            max_size =  max(max_size, end-start+1)
            dupes.add(s[end])  
            end+=1  
        return max_size    