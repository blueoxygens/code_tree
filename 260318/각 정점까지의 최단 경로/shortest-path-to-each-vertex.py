import heapq
import math
n, m = map(int, input().split())
k = int(input())
edges = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
graph = [[] for _ in range(n+1)]
for f, t, v in edges:
    graph[f].append((v,t))
    graph[t].append((v,f))

distance = [math.inf] * (n+1)
distance[k] = 0
heap = [(0,k)]

while heap:
    cost, node = heapq.heappop(heap)

    if cost > distance[node]:
        continue
    
    for next_cost, next_node in graph[node]:
        new_cost = cost + next_cost
        if new_cost < distance[next_node]:
            distance[next_node] = new_cost
            heapq.heappush(heap,(new_cost, next_node))


for i in range(1,n+1):
    print(distance[i]) if distance[i] < math.inf else print(-1)
