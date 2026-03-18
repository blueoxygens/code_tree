import heapq
import math
n, m = map(int, input().split())
k = int(input())
edges = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
distance = [math.inf] * (n+1)
distance[k] = 0
visited = set()
visited.add(k)
heap = []
for f, t, v in edges:
    heapq.heappush(heap, (v,f,t))

while heap:
    cost, n1, n2 = heapq.heappop(heap)
    temp = []
    while n1 not in visited and n2 not in visited:
        if not heap:
            break
        temp.append((cost,n1,n2))
        cost, n1, n2 = heapq.heappop(heap)
    if n1 in visited:
        new_cost = distance[n1] + cost
        if distance[n2] > new_cost:
            distance[n2] = new_cost
        visited.add(n2)
    if n2 in visited:
        new_cost = distance[n2] + cost
        if distance[n1] > new_cost:
            distance[n1] = new_cost
        visited.add(n1)
    for t in temp:
        heapq.heappush(heap, t)

for i in range(1,n+1):
    print(distance[i]) if distance[i] != math.inf else print(-1)

        

