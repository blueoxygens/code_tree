import math
import heapq
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
edge = [[0]*(n+1) for _ in range(n+1)]
for v1, v2, l in edges:
    edge[v1][v2] = l

distance = [math.inf]*(n+1)
distance[1] = 0
h =[]
for i in range(1, n+1):
    heapq.heappush(h, (distance[i],i))

while h:
    d, num = heapq.heappop(h)
    for i in range(1,n+1):
        l = edge[num][i]
        if l > 0:
            if distance[i] > d + l:
                if (distance[i], i) in h:
                    h.remove((distance[i], i))
                heapq.heappush(h, (d+l, i))
                distance[i] = d + l

for i in range(2,n+1):
    d = distance[i]
    if d == math.inf:
        print(-1)
    else:
        print(d)