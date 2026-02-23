class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        frequency = dict()
        start = 0
        end = 0
        max_size = 0
        max_freq = 0
        while end < len(s):

            if frequency.get(s[end], -1) == -1:
                frequency[s[end]] = 1
            else: frequency[s[end]] = frequency.get(s[end]) + 1

            max_freq = max(max_freq, frequency.get(s[end]))
            
            while start < end and (end - start + 1) - max_freq > k:
                curr_char = s[start]
                frequency[curr_char] = frequency.get(curr_char) - 1
                if frequency[curr_char] == 0:
                    frequency.pop(curr_char)  
                start+=1  
                  
            max_size = max(max_size, end - start + 1)

            end+=1
        return max_size    

                