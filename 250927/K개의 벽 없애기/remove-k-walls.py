from collections import deque
import math

n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
r1, c1 = map(int, input().split())
r2, c2 = map(int, input().split())

r1 -= 1
c1 -= 1
r2 -= 1
c2 -= 1

# Please write your code here.
d = [(-1,0),(1,0),(0,-1),(0,1)] #상하좌우
record = []

def bfs():
    q = deque()
    q.append((r1, c1, 0))
    visited = set()
    while q:
        r,c, lv = q.popleft()
        for dr, dc in d:
            nr = r+dr
            nc = c+dc
            if nr == r2 and nc == c2:
                return lv+1
            if 0 <= nr <n and 0 <= nc <n and grid[nr][nc] == 0 and (nr,nc) not in visited:
                q.append((nr,nc, lv+1))
        visited.add((r,c))
    return math.inf
                

walls = []

for r in range (n):
    for c in range(n):
        if grid[r][c] == 1:
            walls.append((r,c))

ans = math.inf

for i in range(len(walls)):
    for j in range(i+1, len(walls)):
        y1, x1 = walls[i]
        y2, x2 = walls[j]
        grid[y1][x1], grid[y2][x2] = 0, 0
        ans = min(ans, bfs())
        grid[y1][x1], grid[y2][x2] = 1, 1

if ans == math.inf:
    print(-1)
else:
    print(ans)