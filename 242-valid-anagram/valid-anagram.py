class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        if len(t) != len(s): return False
        s_map = dict()
        t_map = dict()

        for i in range(0,len(s)):
            s_map[s[i]] = s_map.get(s[i],0) + 1

        for i in range(0,len(t)):
            t_map[t[i]] = t_map.get(t[i],0) + 1

        for key in t_map.keys(): 
            if t_map.get(key) != s_map.get(key): 
                return False

        return True        


