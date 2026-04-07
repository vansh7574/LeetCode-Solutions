class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        left = 0 
        right = m * n - 1 

        while left <= right:
            pivot_idx = (left + right) // 2
            row = pivot_idx // n
            col = pivot_idx % n
            pivot_element = matrix[row][col]
            if target == pivot_element:
                return True
            else: 
                if target < pivot_element:
                    right = pivot_idx - 1
                else:
                    left = pivot_idx + 1
        return False                  
