from collections import deque

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dir = [(-1,0),(1,0),(0,-1),(0,1)]
visited = [[False]*n for _ in range(n)]
stack = deque()
ans = 0
explode = 0

for i in range(n):
    for j in range(n):
        if visited[i][j]:
            continue
        #탐색
        stack.append((i,j))
        visited[i][j] = True
        comp = 0
        while stack:
            r,c = stack.pop()
            for dr, dc in dir:
                nr = r + dr
                nc = c + dc
                if 0<=nr<n and 0<=nc<n and not visited[nr][nc] and grid[r][c] == grid[nr][nc]:
                    stack.append((nr,nc))
                    visited[nr][nc] = True
            comp += 1
        if comp >= 4:
            ans += 1
        explode = max(explode, comp)
        

print(f'{ans} {explode}')