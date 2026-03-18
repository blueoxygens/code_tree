import math
import heapq

n, m = map(int, input().split())
# k = int(input())
edges = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
graph = [[] for _ in range(n+1)]
for f, t, v in edges:
    graph[t].append((v,f))
distance = [math.inf] * (n+1)
distance[n] = 0
heap = [(0,n)]

while heap:
    cost, node = heapq.heappop(heap)

    if cost > distance[node]:
        continue

    for ncost, nnode in graph[node]:
        new_cost = cost + ncost

        if distance[nnode] > new_cost:
            distance[nnode] = new_cost
            heapq.heappush(heap, (new_cost,nnode))

print(max(distance[1:]))