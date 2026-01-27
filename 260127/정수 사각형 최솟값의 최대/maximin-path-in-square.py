from collections import deque
import math

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dirs = [(0,1),(1,0)]

dp = [[math.inf]*(n+1) for _ in range(n+1)]
dp[1][1] = grid[0][0]
q = deque([(1,1)])
visited = [[0]*(n+1) for _ in range(n+1)]
visited[1][1] = 1

while q:
    r, c = q.popleft()
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0<=nr<=n and 0<=nc<=n and visited[nr][nc] == 0:
            dp[nr][nc] = max(min(dp[nr-1][nc], grid[nr-1][nc-1]), min(dp[nr][nc-1], grid[nr-1][nc-1]))
            q.append((nr,nc))
            visited[nr][nc] = 1

# for l in dp:
#     print(*l)

print(dp[n][n])