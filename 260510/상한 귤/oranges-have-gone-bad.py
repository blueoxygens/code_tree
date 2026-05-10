from collections import deque
n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
# dirs = [(1,0),(1,1),(0,1),(-1,1),(-1,0),(-1,-1),(0,-1),(1,-1)]
dirs = [(1,0),(0,1),(-1,0),(0,-1)]
start = []
ans = [[-2]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if grid[i][j] == 2:
            start.append((i,j, 0))
            ans[i][j] = 0
        elif grid[i][j] == 0:
            ans[i][j] = -1

q = deque(start)
visited = set(start)

def inrange(r,c):
    if 0<=r<n and 0<=c<n:
        return True
    return False

while q:
    r, c, t = q.popleft()

    for dr, dc in dirs:
        nr, nc = r + dr, c +dc

        if inrange(nr,nc) and (nr,nc) not in visited and grid[nr][nc] == 1:
            q.append((nr,nc,t+1))
            visited.add((nr,nc))
            ans[nr][nc] = t+1

for l in ans:
    print(*l)
