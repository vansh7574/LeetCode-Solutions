class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        encoded = ""
        for curr_str in strs:
            encoded += str(len(curr_str)) + '#' + curr_str
        return encoded    

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        if s == "": return [""]
        res = []
        pointer = 0
        while pointer < len(s):
            curr_len = ""
            while s[pointer] != '#':
                   curr_len += s[pointer]
                   pointer += 1
            pointer +=1
            int_len = int(curr_len)
            curr_string = ""
            str_range = pointer + int_len
            while pointer < str_range:
                curr_string += s[pointer]
                pointer+=1
            res.append(curr_string)
        return res        

        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))