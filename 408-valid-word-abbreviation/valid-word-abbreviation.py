class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        abr_pointer = 0
        word_pointer = 0
        while abr_pointer < len(abbr):
            if abbr[abr_pointer].isdigit():
                str_len = ""
                while abr_pointer < len(abbr) and abbr[abr_pointer].isdigit():
                    str_len+=abbr[abr_pointer]
                    abr_pointer+=1
                if str_len[0] == "0": return False    
                int_len = int(str_len)
                if word_pointer + int_len <= len(word):
                    word_pointer += int_len
                else: return False        
            elif abr_pointer < len(abbr) and word_pointer < len(word) and abbr[abr_pointer] == word[word_pointer]:
                 abr_pointer+=1
                 word_pointer+=1
            else: return False
            
        return abr_pointer == len(abbr) and word_pointer == len(word)