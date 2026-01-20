from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
adj = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

parent = [0] * (n + 1)
visited = [False] * (n + 1)

q = deque([1])
visited[1] = True

while q:
    x = q.popleft()
    for nx in adj[x]:
        if not visited[nx]:
            visited[nx] = True
            parent[nx] = x
            q.append(nx)

out = []
for i in range(2, n + 1):
    out.append(str(parent[i]))
print("\n".join(out))