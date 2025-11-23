from collections import deque
n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
points = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
dirs = [(-1,0),(1,0),(0,-1),(0,1)] #상하좌우

count = 0

q = deque(points)
visited = set()
for i in range(k):
    visited.add(points[i])

while q:
    r, c = q.popleft()

    for dr, dc in dirs:
        nr = r +dr
        nc = c +dc

        if 1<= nr <= n and 1<= nc <= n and (nr,nc) not in visited and grid[nr-1][nc-1] != 1:
            q.append((nr,nc))
            visited.add((nr,nc))

ans = len(visited)

print(ans)
        