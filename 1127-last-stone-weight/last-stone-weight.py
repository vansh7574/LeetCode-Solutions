import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
         maxheap = [-x for x in stones]
         heapq.heapify(maxheap)
         while len(maxheap) > 1:
              largest = -heapq.heappop(maxheap)
              secondlargest = -heapq.heappop(maxheap)
              heapq.heappush(maxheap,-(largest-secondlargest)) 
         if len(maxheap) == 1: return -maxheap[0]
         else: return 0               