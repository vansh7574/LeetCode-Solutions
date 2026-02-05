import heapq
import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        res = []
        heap = []
        for point in points:
            priority = math.sqrt(point[0] ** 2 + point[1] ** 2)
            payload = point
            heapq.heappush(heap,(priority, payload))

        for i in range(0,k):
            res.append(heapq.heappop(heap)[1])

        return res    