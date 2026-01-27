class Solution:
    def simplifyPath(self, path: str) -> str:
        split_path = path.split("/")
        filtered_path = []
        for dir in split_path:
            if dir == '':
               continue
            else: filtered_path.append(dir)
        # print(filtered_path)   
        stk = []
        # stk.append("/")
        for dir in filtered_path:
            if dir != '..' and dir != '.':
               stk.append(dir)
            elif len(stk)!= 0 and dir == '..':
                stk.pop(-1)
            elif dir == '.':
                continue
        res = "/".join(stk)                      
        res = "/" + res
        # print(res)
        return res