class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        freqtable = {}
        output = []
        #seen = set()
        for i in range(len(arr1)):
           if arr1[i] in freqtable:
                freqtable[arr1[i]] = freqtable[arr1[i]] + 1
           else: freqtable[arr1[i]] = 1      
        
        for i in range(len(arr2)):
            num = arr2[i]
            freq = freqtable[num]
            if num in freqtable:
                for j in range(0, freq):
                    output.append(num)
                del freqtable[num]

        for i in sorted(freqtable):
            output.extend([i]*freqtable[i])
        
        return output
        
        


            


        