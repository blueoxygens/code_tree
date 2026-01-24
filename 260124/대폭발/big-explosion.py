n, m, r, c = map(int, input().split())

# Please write your code here.
dirs = [(1,0),(-1,0),(0,1),(0,-1)]
grid = [[False]*n for _ in range(n)]

grid[r-1][c-1] = 1
ans = 1

cpoints = [(r-1,c-1)]

dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

for t in range(m):
    npoints = []
    jump = 2**t

    for cr, cc in cpoints:
        for dr, dc in dirs:
            nr, nc = cr + dr * jump, cc + dc * jump

            if 0<= nr <n and 0<= nc < n:
                if grid[nr][nc] == 0:
                    grid[nr][nc] = 1
                    npoints.append((nr,nc))
                    ans += 1
    
    cpoints.extend(npoints)

print(ans)