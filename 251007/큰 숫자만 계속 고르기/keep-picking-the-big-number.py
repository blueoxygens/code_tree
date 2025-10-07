from collections import deque
import heapq

n, m = map(int, input().split())
arr = list(map(int, input().split()))
q =[]
# Please write your code here.
for i in arr:
    heapq.heappush(q, -i)
# heapq.heappush()
for _ in range(m):
    heapq.heappush(q, heapq.heappop(q)+1)

print(-heapq.heappop(q))