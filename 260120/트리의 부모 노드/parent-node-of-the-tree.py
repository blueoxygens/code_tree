from collections import deque
n = int(input())
edges = [tuple(map(int, input().split())) for _ in range(n - 1)]

# Please write your code here.
edge = [[-1]*(n+1) for _ in range(n+1)]
for n1, n2 in edges:
    edge[n1][n2], edge[n2][n1] = 1, 1

p = {}

q = deque()
visited = set()
q.append(1)
visited.add(1)

while q:
    t = q.popleft()
    for i in range(1,n+1):
        if i not in visited and edge[t][i] == 1:
            p[i] = t
            q.append(i)
            visited.add(i)

for i in range(2, n+1):
    print(p[i])